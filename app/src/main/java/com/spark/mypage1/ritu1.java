package com.spark.mypage1;



import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class ritu1 extends AppCompatActivity {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(new Locale("mr", "IN")); // Marathi
            }
        });

        setButtonListener(R.id.btnTala, "तला");
        setButtonListener(R.id.btnKumar, "कुमार");
        setButtonListener(R.id.btnRumal, "रुमाल");
        setButtonListener(R.id.btnSabak, "सबक");
        setButtonListener(R.id.btnPal, "पल");
        setButtonListener(R.id.btnTap, "तप");
        setButtonListener(R.id.btnSan, "सन");
        setButtonListener(R.id.btnKapas, "कापस");
    }

    private void setButtonListener(int buttonId, String word) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> tts.speak(word, TextToSpeech.QUEUE_FLUSH, null, null));
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

