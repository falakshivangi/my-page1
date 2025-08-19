package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.vp6;

public class vp6 extends AppCompatActivity {

    RadioGroup radioGroupQ1, radioGroupQ2, radioGroupQ3;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // your XML file name



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        int score = 0;

        // ✅ Correct answers:
        // Q1 → फळझाडे व फुलझाडे  (q1Option2)
        // Q2 → सुंदर व फुलांनी भरलेली  (q2Option1)
        // Q3 → फळे व फुले (q3Option2)

        int selectedQ1 = radioGroupQ1.getCheckedRadioButtonId();
        int selectedQ2 = radioGroupQ2.getCheckedRadioButtonId();
        int selectedQ3 = radioGroupQ3.getCheckedRadioButtonId();

        if (selectedQ1 == -1 || selectedQ2 == -1 || selectedQ3 == -1) {
            Toast.makeText(this, "कृपया सर्व प्रश्नांची उत्तरे निवडा.", Toast.LENGTH_SHORT).show();
            return;
        }



        Toast.makeText(this, "तुमचे गुण: " + score + "/3", Toast.LENGTH_LONG).show();
    }
}
