package com.spark.mypage1;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GhaarExerciseActivity extends AppCompatActivity {

    EditText etQ1, etQ2, etQ3;
    Button btnSubmit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priya);

        // Binding Views
        etQ1 = findViewById(R.id.et_q1);
        etQ2 = findViewById(R.id.et_q2);
        etQ3 = findViewById(R.id.et_q3);
        btnSubmit = findViewById(R.id.btn_submit);

        // Button Click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1 = etQ1.getText().toString().trim();
                String answer2 = etQ2.getText().toString().trim();
                String answer3 = etQ3.getText().toString().trim();

                // Check if any answer is empty
                if (answer1.isEmpty() || answer2.isEmpty() || answer3.isEmpty()) {
                    Toast.makeText(GhaarExerciseActivity.this, "कृपया सर्व प्रश्नांची उत्तरे भरा", Toast.LENGTH_SHORT).show();
                } else {
                    // Show entered answers in Toast
                    String result = "उत्तर १: " + answer1 + "\n" +
                            "उत्तर २: " + answer2 + "\n" +
                            "उत्तर ३: " + answer3;

                    Toast.makeText(GhaarExerciseActivity.this, result, Toast.LENGTH_LONG).show();

                    // Optional: Clear all fields after submission
                    etQ1.setText("");
                    etQ2.setText("");
                    etQ3.setText("");
                }
            }
        });
    }
}

