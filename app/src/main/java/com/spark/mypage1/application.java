package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.application;

import java.util.Arrays;

public class application extends AppCompatActivity {

    TextView tvLetter, tvResult, tvScore;
    ImageView option1, option2, option3, option4;
    Button btnNext;

    int currentIndex = 0;
    int score = 0;

    String[] letters = {"च", "ळ", "ह", "झ", "ए"};
    int[][] options = {
            {R.drawable.chak, R.drawable.img_1, R.drawable.img, R.drawable.mala}, // च
            {R.drawable.nal, R.drawable.img_3, R.drawable.zopadi, R.drawable.ganpati},  // ळ
            {R.drawable.hiran, R.drawable.dog, R.drawable.safarchand, R.drawable.img_2},       // ह
            {R.drawable.jhadu, R.drawable.airplane, R.drawable.dam, R.drawable.hat},  // झ
    };
    int[] correctIndex = {0, 0, 0, 0, 0}; // All correct options at index 0 for now

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLetter = findViewById(R.id.tv_letter);
        tvResult = findViewById(R.id.tv_result);
        tvScore = findViewById(R.id.tv_score);
        btnNext = findViewById(R.id.btn_next);

        option1 = findViewById(R.id.option3);
        option2 = findViewById(R.id.option4);
        option3 = findViewById(R.id.option1);
        option4 = findViewById(R.id.option2);

        loadQuestion();

        View.OnClickListener answerClickListener = view -> {
            int clickedIndex = -1;
            if (view.getId() == R.id.option3) clickedIndex = 0;
            else if (view.getId() == R.id.option4) clickedIndex = 1;
            else if (view.getId() == R.id.option1) clickedIndex = 2;
            else if (view.getId() == R.id.option2) {
                clickedIndex = 3;
            }

            if (clickedIndex == correctIndex[currentIndex]) {
                tvResult.setText("✔️ बरोबर!");
                score++;
                tvScore.setText("Score: " + score);
            } else {
                tvResult.setText("❌ चुकलं!");
            }
        };

        for (ImageView imageView : Arrays.asList(option1, option2, option3, option4))
            imageView.setOnClickListener(answerClickListener);

        btnNext.setOnClickListener(view -> {
            currentIndex = (currentIndex + 1) % letters.length;
            tvResult.setText("");
            loadQuestion();
        });
    }

    private void loadQuestion() {
        tvLetter.setText(letters[currentIndex]);
        option1.setImageResource(options[currentIndex][0]);
        option2.setImageResource(options[currentIndex][1]);
        option3.setImageResource(options[currentIndex][2]);
        option4.setImageResource(options[currentIndex][3]);
    }
}
