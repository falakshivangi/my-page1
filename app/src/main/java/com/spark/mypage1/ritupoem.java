package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class ritupoem extends AppCompatActivity {

    private TextToSpeech tts;
    private Button firstSelected = null;
    private TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poemritu);

        /* ----------  T T S  ---------- */
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(new Locale("mr", "IN"));
            }
        });

        /* ---------- pronounce whole poem when tapped  ---------- */
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView poem = findViewById(R.id.tvPoem);
        poem.setOnClickListener(v -> speak(poem.getText().toString()));

        /* ---------- rhyming buttons ---------- */
        int[] ids = {R.id.btnBaanhl, R.id.btnPahkl, R.id.btnGhaatl, R.id.btnTaangl};
        for (int id : ids) {
            Button b = findViewById(id);
            b.setOnClickListener(this::onRhymeClicked);
            b.setOnLongClickListener(v -> {   // long‑press reads the word only
                speak(b.getText().toString());
                return true;
            });
        }

        tvResult = findViewById(R.id.tvResult);
    }

    /* ---------- rhyme‑pair tap logic ---------- */
    private void onRhymeClicked(View v) {
        Button tapped = (Button) v;

        if (firstSelected == null) {                 // 1st tap
            firstSelected = tapped;
            tapped.setEnabled(false);               // visually mark it
        } else {                                    // 2nd tap
            if (isPair(firstSelected, tapped)) {
                speak("योग्य जुळवणी!");
                tvResult.setText("छान ! योग्य जोड्या झाल्या.");
                firstSelected.setVisibility(View.INVISIBLE);
                tapped.setVisibility(View.INVISIBLE);
            } else {
                speak("चूक झाली, पुन्हा प्रयत्न करा.");
                tvResult.setText("चूक ‑ पुन्हा प्रयत्न करा");
                firstSelected.setEnabled(true);
            }
            firstSelected = null;
        }
    }

    // very small word‑set → hard‑code the two correct pairs
    private boolean isPair(Button b1, Button b2) {
        String w1 = b1.getText().toString();
        String w2 = b2.getText().toString();
        return (w1.equals("बांधलं") && w2.equals("घातलं")) ||
                (w1.equals("घातलं") && w2.equals("बांधलं")) ||
                (w1.equals("पक्कळं") && w2.equals("टांगलं")) ||
                (w1.equals("टांगलं") && w2.equals("पक्कळं"));
    }

    /* ---------- helper ---------- */
    private void speak(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "ID1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
