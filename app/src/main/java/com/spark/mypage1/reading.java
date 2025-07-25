package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class reading extends AppCompatActivity {

    RadioGroup q1Group, q2Group, q3Group;
    Button submitBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading);

        q1Group = findViewById(R.id.q1Group);
        q2Group = findViewById(R.id.q2Group);
        q3Group = findViewById(R.id.q3Group);
        submitBtn = findViewById(R.id.submitBtn);
        resultText = findViewById(R.id.resultText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Q1 Correct Answer: "काल आला"
                int q1Selected = q1Group.getCheckedRadioButtonId();
                if (q1Selected != -1) {
                    RadioButton q1 = findViewById(q1Selected);
                    if (q1.getText().toString().equals("काल आला")) {
                        score++;
                    }
                }

                // Q2 Correct Answer: "काका, मामा, लाला, आलम"
                int q2Selected = q2Group.getCheckedRadioButtonId();
                if (q2Selected != -1) {
                    RadioButton q2 = findViewById(q2Selected);
                    if (q2.getText().toString().equals("काका, मामा, लाला, आलम")) {
                        score++;
                    }
                }

                // Q3 Correct Answer: "भेटायला आले"
                int q3Selected = q3Group.getCheckedRadioButtonId();
                if (q3Selected != -1) {
                    RadioButton q3 = findViewById(q3Selected);
                    if (q3.getText().toString().equals("भेटायला आले")) {
                        score++;
                    }
                }

                // Display Result
                resultText.setText("तुमचे गुण: " + score + "/3");
            }
        });
    }
}
