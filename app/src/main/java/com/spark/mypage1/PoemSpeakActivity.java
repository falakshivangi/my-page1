package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class PoemSpeakActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView poemTv;
    private Button playBtn, stopBtn;

    private final String poem =
            "१५. झुक झुक झुक\n\n" +
                    "गाडी आली गाडी आली — झुक झुक झुक\n" +
                    "शिटी कशी वाजे बघा — कुकू कुक कुक\n" +
                    "इंजनाचा धूर निघे — भक भक भक\n" +
                    "चाके पाहा टपाटप — ठक ठक ठक\n" +
                    "जायचे का दूर कोठे — भुर भुर भुर\n" +
                    "कोठेही जा नेऊन घे — दूर दूर दूर\n" +
                    "तिकीटाचे पैसे काढा — छन छन छन\n" +
                    "गाडीतही घंटा वाजे — घण घण घण\n" +
                    "गाडीमध्ये बसून चला — पट पट पट\n" +
                    "सामानही ठेव सारे — चट चट चट\n" +
                    "नका बसू डोळकाढून — शुक शुक शुक\n" +
                    "गाडी आता निघालीच — झुक झुक झुक\n";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zukzuk);

        poemTv  = findViewById(R.id.poemTv);
        playBtn = findViewById(R.id.playBtn);
        stopBtn = findViewById(R.id.stopBtn);

        poemTv.setText(poem);

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                // Try Marathi first, fall back to Indian Marathi tag, then default
                int result = tts.setLanguage(new Locale("mr", "IN"));
                if (result == TextToSpeech.LANG_MISSING_DATA ||
                        result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    result = tts.setLanguage(Locale.forLanguageTag("mr-IN"));
                }
                if (result == TextToSpeech.LANG_MISSING_DATA ||
                        result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(this, "Marathi TTS not found, using default voice.", Toast.LENGTH_SHORT).show();
                }
                tts.setPitch(1.0f);   // normal pitch
                tts.setSpeechRate(0.9f); // slightly slower for kids
            } else {
                Toast.makeText(this, "TTS init failed", Toast.LENGTH_SHORT).show();
            }
        });

        playBtn.setOnClickListener(v -> speakPoem());
        stopBtn.setOnClickListener(v -> {
            if (tts != null) tts.stop();
        });

        // Tap any line to speak just that line
        poemTv.setOnLongClickListener(v -> {
            String sel = poemTv.getText().toString();
            int start = Math.max(poemTv.getSelectionStart(), 0);
            int end   = Math.max(poemTv.getSelectionEnd(), 0);
            if (end > start) {
                String part = sel.substring(start, end).trim();
                if (!part.isEmpty()) speakText(part);
            }
            return true;
        });
    }

    private void speakPoem() {
        if (tts == null) return;
        speakText(poem);
    }

    private void speakText(String text) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "POEM_ID");
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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
