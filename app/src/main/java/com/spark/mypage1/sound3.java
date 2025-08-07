package com.spark.mypage1;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class sound3 extends AppCompatActivity {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound3);

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(new Locale("mr", "IN"));  // Marathi
            }
        });

        setupClick(findViewById(R.id.image_yak), "धरण");
        setupClick(findViewById(R.id.text_dam), "धरण");

        setupClick(findViewById(R.id.image_dhotra), "धोतर");
        setupClick(findViewById(R.id.text_dhotra), "धोतर");

        setupClick(findViewById(R.id.image_yak), "याक");
        setupClick(findViewById(R.id.text_yak), "याक");

        setupClick(findViewById(R.id.image_rocket), "यान");
        setupClick(findViewById(R.id.speak_rocket), "यान");
    }

    private void setupClick(View view, String word) {
        view.setOnClickListener(v -> {
            tts.speak(word, TextToSpeech.QUEUE_FLUSH, null, null);
        });
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
