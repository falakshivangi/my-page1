package com.spark.mypage1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class vp5 extends AppCompatActivity {

    RadioGroup q1Group, q2Group, q3Group, q4Group;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp5);

        q1Group = findViewById(R.id.q1Group);
        q2Group = findViewById(R.id.q2Group);
        q3Group = findViewById(R.id.q3Group);
        q4Group = findViewById(R.id.q4Group);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> checkAnswers());
    }

    private void checkAnswers() {
        int score = 0;

        // Correct answers: Q1 -> सहलिला (q1b), Q2 -> मजा करण्यासाठी केलेला प्रवास (q2b),
        // Q3 -> लाडू, चिवडा, चपाती, ऊसळ (q3a), Q4 -> सर्वच (q4c)
        if (q1Group.getCheckedRadioButtonId() == R.id.q1b) score++;
        if (q2Group.getCheckedRadioButtonId() == R.id.q2b) score++;
        if (q3Group.getCheckedRadioButtonId() == R.id.q3a) score++;
        if (q4Group.getCheckedRadioButtonId() == R.id.q4c) score++;

        Toast.makeText(this, "तुमचे गुण: " + score + "/4", Toast.LENGTH_SHORT).show();
    }
}
