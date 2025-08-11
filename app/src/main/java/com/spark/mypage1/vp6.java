package com.spark.mypage1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class vp6 extends AppCompatActivity {

    RadioGroup q1Group, q2Group, q3Group;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp6);

        q1Group = findViewById(R.id.q1Group);
        q2Group = findViewById(R.id.q2Group);
        q3Group = findViewById(R.id.q3Group);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> checkAnswers());
    }

    private void checkAnswers() {
        int score = 0;

        // Correct: Q1 -> q1a, Q2 -> q2a, Q3 -> q3a
        if (q1Group.getCheckedRadioButtonId() == R.id.q1a) score++;
        if (q2Group.getCheckedRadioButtonId() == R.id.q2a) score++;
        if (q3Group.getCheckedRadioButtonId() == R.id.q3a) score++;

        Toast.makeText(this, "तुमचे गुण: " + score + "/3", Toast.LENGTH_SHORT).show();
    }
}
