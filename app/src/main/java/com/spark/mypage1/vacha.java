package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class vacha extends AppCompatActivity {

    RadioGroup q1Group, q2Group;
    EditText q3Answer, q4Answer;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacha);

        q1Group = findViewById(R.id.q1_group);
        q2Group = findViewById(R.id.q2_group);
        q3Answer = findViewById(R.id.q3_answer);
        q4Answer = findViewById(R.id.q3_answer);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans1 = getSelectedAnswer(q1Group);
                String ans2 = getSelectedAnswer(q2Group);
                String ans3 = q3Answer.getText().toString().trim();
                String ans4 = q4Answer.getText().toString().trim();

                String result = "तुमची उत्तरे:\n\n" +
                        "१) " + ans1 + "\n" +
                        "२) " + ans2 + "\n" +
                        "३) " + ans3 + "\n" +
                        "४) " + ans4;

                Toast.makeText(vacha.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getSelectedAnswer(RadioGroup group) {
        int selectedId = group.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton rb = findViewById(selectedId);
            return rb.getText().toString();
        }
        return "उत्तर दिले नाही";
    }
}
