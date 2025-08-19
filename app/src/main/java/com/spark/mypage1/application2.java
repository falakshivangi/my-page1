package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.application2;

import java.util.Locale;

public class application2 extends AppCompatActivity {

    ToggleButton toggleApple, toggleBall, toggleCat, toggleDog;
    TextToSpeech tts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link buttons
        toggleApple = findViewById(R.id.toggleApple);
        toggleBall = findViewById(R.id.toggleBall);
        toggleCat = findViewById(R.id.toggleCat);
        toggleDog = findViewById(R.id.toggleDog);

        // Initialize Text-to-Speech
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(new Locale("mr", "IN")); // Marathi
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(Locale.US); // Fallback
                }
            }
        });

        // Set click listeners
        toggleApple.setOnClickListener(v -> speakWord(toggleApple.getText().toString()));
        toggleBall.setOnClickListener(v -> speakWord(toggleBall.getText().toString()));
        toggleCat.setOnClickListener(v -> speakWord(toggleCat.getText().toString()));
        toggleDog.setOnClickListener(v -> speakWord(toggleDog.getText().toString()));
    }

    private void speakWord(String word) {
        if (tts != null && !word.isEmpty()) {
            tts.speak(word, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
