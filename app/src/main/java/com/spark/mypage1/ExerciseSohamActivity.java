package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseSohamActivity extends AppCompatActivity {

    RadioGroup q1_group, q2_group, q3_group;
    Button submitButton;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3);

        q1_group = findViewById(R.id.q1_group);
        q2_group = findViewById(R.id.q2_group);
        q3_group = findViewById(R.id.q3_group);
        submitButton = findViewById(R.id.submitButton);
        resultTextView = findViewById(R.id.resultTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Q1 correct: "दात घासतो, अंघोळ करतो, जेवतो"
                RadioButton selected1 = findViewById(q1_group.getCheckedRadioButtonId());
                if (selected1 != null && selected1.getText().toString().equals("दात घासतो, अंघोळ करतो, जेवतो")) score++;

                // Q2 correct: "आजी"
                RadioButton selected2 = findViewById(q2_group.getCheckedRadioButtonId());
                if (selected2 != null && selected2.getText().toString().equals("आजी")) score++;

                // Q3 correct: "अभ्यास करतो, खेळतो, जेवतो"
                RadioButton selected3 = findViewById(q3_group.getCheckedRadioButtonId());
                if (selected3 != null && selected3.getText().toString().equals("अभ्यास करतो, खेळतो, जेवतो")) score++;

                resultTextView.setText("तुमचं गुण: " + score + "/3");
            }
        });
    }
}

