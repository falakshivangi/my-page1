package com.spark.mypage1;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class newp extends AppCompatActivity {

    TextToSpeech tts;
    ToggleButton toggleAi, toggleBaba, toggleAjob, toggleAjji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newp);  // Your XML filename

        toggleAi = findViewById(R.id.toggle_ai);
        toggleBaba = findViewById(R.id.toggle_baba);
        toggleAjob = findViewById(R.id.toggle_ajoba);
        toggleAjji = findViewById(R.id.toggle_ajji);

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(new Locale("mr", "IN"));  // Marathi language
            }
        });

        setupToggle(toggleAi, "आई");
        setupToggle(toggleBaba, "बाबा");
        setupToggle(toggleAjob, "आजोबा");
        setupToggle(toggleAjji, "आजी");
    }

    private void setupToggle(ToggleButton toggle, String text) {
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                buttonView.setChecked(false);  // Reset toggle after speaking
            }
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
