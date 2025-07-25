package com.spark.mypage1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BhoplaQuizActivity extends AppCompatActivity {

    RadioGroup q1_group, q2_group, q3_group;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poemmm);

        q1_group = findViewById(R.id.q1_group);
        q2_group = findViewById(R.id.q2_group);
        q3_group = findViewById(R.id.q3_group);
        submit_btn = findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        int score = 0;

        // Correct answers: Q1 = बाजारात, Q2 = भोपळा, Q3 = बी

        if (q1_group.getCheckedRadioButtonId() == R.id.q1_option1) {
            score++;
        }
        if (q2_group.getCheckedRadioButtonId() == R.id.q2_option1) {
            score++;
        }
        if (q3_group.getCheckedRadioButtonId() == R.id.q3_option1) {
            score++;
        }

        Toast.makeText(this, "तुमचा स्कोर: " + score + "/3", Toast.LENGTH_LONG).show();
    }
}
