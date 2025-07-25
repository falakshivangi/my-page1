package com.spark.mypage1;



import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class WordActivity extends AppCompatActivity {

    EditText flower1, flower2, flower3, riddleAnswer, foundWords;
    Button checkRiddleBtn;
    GridLayout wordSearchGrid;

    String riddleCorrectAnswer = "ससा"; // उदाहरणार्थ

    String[][] wordSearchLetters = {
            {"घ","आ","ला","ब"},
            {"र","ई","ता","क"},
            {"उ","मा","नी","ई"},
            {"स","सा","पू","ल"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);

        flower1 = findViewById(R.id.flower1);
        flower2 = findViewById(R.id.flower2);
        flower3 = findViewById(R.id.flower3);
        riddleAnswer = findViewById(R.id.riddleAnswer);
        foundWords = findViewById(R.id.foundWords);
        checkRiddleBtn = findViewById(R.id.checkRiddleBtn);
        wordSearchGrid = findViewById(R.id.wordSearchGrid);

        createWordSearchGrid();

        checkRiddleBtn.setOnClickListener(v -> {
            String ans = riddleAnswer.getText().toString().trim();
            if (ans.equals(riddleCorrectAnswer)) {
                Toast.makeText(this, "बरोबर!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "पुन्हा प्रयत्न करा!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createWordSearchGrid() {
        for (int i = 0; i < wordSearchLetters.length; i++) {
            for (int j = 0; j < wordSearchLetters[i].length; j++) {
                TextView tv = new TextView(this);
                tv.setText(wordSearchLetters[i][j]);
                tv.setTextSize(18);
                tv.setPadding(10,10,10,10);
                tv.setBackgroundResource(android.R.drawable.alert_light_frame);
                wordSearchGrid.addView(tv);
            }
        }
    }
}
