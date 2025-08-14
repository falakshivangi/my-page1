package com.spark.mypage1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lesson21QuizActivity extends AppCompatActivity {

    RadioGroup q1Group, q2Group, q3Group, q4Group, q5Group, q6Group, q7Group;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majisuhabati);

        q1Group = findViewById(R.id.q1Group);
        q2Group = findViewById(R.id.q2Group);
        q3Group = findViewById(R.id.q3Group);
        q4Group = findViewById(R.id.q4Group);
        q5Group = findViewById(R.id.q5Group);
        q6Group = findViewById(R.id.q6Group);
        q7Group = findViewById(R.id.q7Group);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> {
            int score = 0;

            // Correct answers:
            if (getSelectedText(q1Group).equals("पोपट")) score++;
            if (getSelectedText(q2Group).equals("झाडावर")) score++;
            if (getSelectedText(q3Group).equals("कुत्रा")) score++;
            if (getSelectedText(q4Group).equals("शेळी")) score++;
            // Q5, Q6, Q7 are opinion-based; we won't score them as right/wrong
            // But if you want, you can set a preferred answer and score them too
            if (getSelectedText(q5Group).equals("दोन्ही")) score++;
            if (getSelectedText(q6Group).equals("दोन्ही")) score++;
            if (getSelectedText(q7Group).equals("दोन्ही")) score++;

            Toast.makeText(this, "तुमचा स्कोअर: " + score + "/7", Toast.LENGTH_LONG).show();
        });
    }

    private String getSelectedText(RadioGroup group) {
        int id = group.getCheckedRadioButtonId();
        if (id == -1) return "";
        RadioButton rb = findViewById(id);
        return rb.getText().toString();
    }
}
