package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.vp4;

public class vp4 extends AppCompatActivity {

    RadioGroup q1Group, q2Group, q3Group, q4Group;
    Button submitBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp4);

        q1Group = findViewById(R.id.q1Group);
        q2Group = findViewById(R.id.q2Group);
        q3Group = findViewById(R.id.q3Group);
        q4Group = findViewById(R.id.q4Group);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> checkAnswers());
    }

    private void checkAnswers() {
        int score = 0;

        // Correct answers: Q1 -> पाला (q1b), Q2 -> सुपलीत (q2b), Q3 -> टोपलीत (q3b), Q4 -> झाडू, सुपली (q4a)
        if (q1Group.getCheckedRadioButtonId() == R.id.q1b) score++;
        if (q2Group.getCheckedRadioButtonId() == R.id.q2b) score++;
        if (q3Group.getCheckedRadioButtonId() == R.id.q3b) score++;
        if (q4Group.getCheckedRadioButtonId() == R.id.q4a) score++;

        Toast.makeText(this, "तुमचे गुण: " + score + "/4", Toast.LENGTH_SHORT).show();
    }
}
