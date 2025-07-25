package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    RadioGroup group1, group2, group3, group4;
    Button submitButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group1 = findViewById(R.id.group1);
        group2 = findViewById(R.id.group2);
        group3 = findViewById(R.id.group3);
        group4 = findViewById(R.id.group4);
        submitButton = findViewById(R.id.submitButton);
        resultText = findViewById(R.id.resultText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Correct answers:
                if (group1.getCheckedRadioButtonId() == R.id.q1a) score++; // All relatives
                if (group2.getCheckedRadioButtonId() == R.id.q2c) score++; // गोड गोड खाऊ
                if (group3.getCheckedRadioButtonId() == R.id.q3a) score++; // आई
                if (group4.getCheckedRadioButtonId() == R.id.q4c) score++; // दादा व वहिनी

                resultText.setText("तुमचे गुण: " + score + " / 4");
            }
        });
    }
}
