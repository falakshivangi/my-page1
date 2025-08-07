package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ssp extends AppCompatActivity {

    GridLayout gridLayout;
    TextView selectedWord, result;
    Button checkButton;

    // Marathi letters grid
    String[] letters = {
            "घ", "आ", "ला", "ब",
            "र", "ई", "ता", "क",
            "ऊ", "मा", "न", "री",
            "स", "सा", "पूल", "ल"
    };

    // Valid Marathi words
    List<String> validWords = Arrays.asList(
            "घर", "बाई", "पूल", "ससा", "मा", "ता", "री", "नरी", "माता", "फुल", "कळा", "घार", "साल"
    );

    ArrayList<String> selected = new ArrayList<>();
    ArrayList<ToggleButton> toggleButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssp);

        gridLayout = findViewById(R.id.gridLayout);
        selectedWord = findViewById(R.id.selectedWord);
        result = findViewById(R.id.result);
        checkButton = findViewById(R.id.checkButton);

        setupGrid();

        checkButton.setOnClickListener(view -> {
            StringBuilder formed = new StringBuilder();
            for (String s : selected) {
                formed.append(s);
            }
            String word = formed.toString();
            if (validWords.contains(word)) {
                result.setText("✅ बरोबर शब्द: " + word);
            } else {
                result.setText("❌ चुकीचा शब्द: " + word);
            }
            clearSelection();
        });
    }

    private void setupGrid() {
        for (String letter : letters) {
            ToggleButton tb = new ToggleButton(this);
            tb.setText(letter);
            tb.setTextOn(letter);
            tb.setTextOff(letter);
            tb.setTextSize(20);
            tb.setPadding(10, 10, 10, 10);
            tb.setMinHeight(120);
            tb.setMinWidth(120);

            tb.setOnClickListener(v -> {
                if (tb.isChecked()) {
                    selected.add(letter);
                } else {
                    selected.remove(letter);
                }
                updateSelectedWord();
            });

            gridLayout.addView(tb);
            toggleButtons.add(tb);
        }
    }

    private void updateSelectedWord() {
        StringBuilder sb = new StringBuilder("निवडलेला शब्द: ");
        for (String s : selected) {
            sb.append(s);
        }
        selectedWord.setText(sb.toString());
    }

    private void clearSelection() {
        for (ToggleButton b : toggleButtons) {
            b.setChecked(false);
        }
        selected.clear();
        updateSelectedWord();
    }
}
