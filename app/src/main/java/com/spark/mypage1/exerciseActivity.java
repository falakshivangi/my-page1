package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class exerciseActivity extends AppCompatActivity {

    RadioGroup q1Group, q2Group;
    EditText q3Answer;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        q1Group = findViewById(R.id.q1_group);
        q2Group = findViewById(R.id.q2_group);
        q3Answer = findViewById(R.id.q3_answer);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Question 1 answer checking
                int selectedQ1 = q1Group.getCheckedRadioButtonId();
                String ans1 = "";
                if (selectedQ1 != -1) {
                    RadioButton rb = findViewById(selectedQ1);
                    ans1 = rb.getText().toString();
                }

                // Question 2 answer checking
                int selectedQ2 = q2Group.getCheckedRadioButtonId();
                String ans2 = "";
                if (selectedQ2 != -1) {
                    RadioButton rb = findViewById(selectedQ2);
                    ans2 = rb.getText().toString();
                }

                // Question 3
                String ans3 = q3Answer.getText().toString().trim();

                // Show Result
                String result = "तुमची उत्तरे:\n\n" +
                        "१) " + ans1 + "\n" +
                        "२) " + ans2 + "\n" +
                        "३) " + ans3;

                Toast.makeText(exerciseActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}

