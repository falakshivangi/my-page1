package com.spark.mypage1;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class WordGridActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private final Set<String> allWords = new HashSet<>();
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo123);

        /* 1.  collect all grid words & set up TTS on each */
        GridLayout grid = findViewById(R.id.gridWords);
        for (int i = 0; i < grid.getChildCount(); i++) {
            Button b = (Button) grid.getChildAt(i);
            String word = b.getText().toString();
            allWords.add(word);

            b.setOnClickListener(view -> {
                view.setBackgroundColor(0xFFCCE5FF);  // blue tint
                speak(word);
            });
        }

        /* 2. TTS engine */
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS)
                tts.setLanguage(new Locale("mr", "IN"));
        });

        /* 3. task boxes & checker */
        et1 = findViewById(R.id.etTask1);
        et2 = findViewById(R.id.etTask2);
        et3 = findViewById(R.id.etTask3);

        findViewById(R.id.btnCheck).setOnClickListener(v -> checkAnswers());
    }

    /* ---------- pronounce helper ---------- */
    private void speak(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "wordId");
    }

    /* ---------- validate learner answers ---------- */
    private void checkAnswers() {

        validateField(et1, w -> w.contains("आ"));
        validateField(et2, w -> w.contains("ई"));
        validateField(et3, w -> w.startsWith("व"));

        Toast.makeText(this, "तपासणी पूर्ण!", Toast.LENGTH_SHORT).show();
    }

    private interface WordRule { boolean ok(String w); }

    private void validateField(EditText box, WordRule rule) {
        String raw = box.getText().toString().trim();
        if (TextUtils.isEmpty(raw)) {
            box.setBackgroundColor(Color.RED);
            return;
        }

        String[] answers = raw.split("\\s+|,");        // space / comma separated
        ArrayList<String> bad = new ArrayList<>();

        for (String a : answers) {
            if (!allWords.contains(a) || !rule.ok(a)) bad.add(a);
        }

        if (bad.isEmpty()) {
            box.setBackgroundColor(Color.parseColor("#C8E6C9"));  // green ✓
        } else {
            box.setBackgroundColor(Color.RED);                     // red ✗
            speak("चूक उत्तर");
        }
    }

    @Override
    protected void onDestroy() {
        if (tts != null) { tts.stop(); tts.shutdown(); }
        super.onDestroy();
    }
}
