package com.spark.mypage1;



import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ExercisePome2Activity extends AppCompatActivity {

    RadioGroup q1_group, q2_group, q3_group, q4_group;
    Button submitButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        q1_group = findViewById(R.id.q1_group);
        q2_group = findViewById(R.id.q2_group);
        q3_group = findViewById(R.id.q3_group);
        q4_group = findViewById(R.id.q4_group);
        submitButton = findViewById(R.id.submitButton);
        resultTextView = findViewById(R.id.resultTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Question 1: No fixed correct answer
                if (q1_group.getCheckedRadioButtonId() != -1) score++;

                // Question 2: Prefer "होय"
                RadioButton q2_selected = findViewById(q2_group.getCheckedRadioButtonId());
                if (q2_selected != null && q2_selected.getText().toString().equals("होय")) score++;

                // Question 3: Accept "भिजायला मजा येते" or "निसर्ग सुंदर दिसतो"
                RadioButton q3_selected = findViewById(q3_group.getCheckedRadioButtonId());
                if (q3_selected != null) {
                    String ans = q3_selected.getText().toString();
                    if (ans.equals("भिजायला मजा येते") || ans.equals("निसर्ग सुंदर दिसतो")) score++;
                }

                // Question 4: Accept "सार्वत्र हिरवळ पसरते" or "पाणी साचते"
                RadioButton q4_selected = findViewById(q4_group.getCheckedRadioButtonId());
                if (q4_selected != null) {
                    String ans = q4_selected.getText().toString();
                    if (ans.equals("सार्वत्र हिरवळ पसरते") || ans.equals("पाणी साचते")) score++;
                }

                resultTextView.setText("तुमचं गुण: " + score + "/4");
            }
        });
    }
}
