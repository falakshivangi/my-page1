package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class marathi extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioFarmer, radioDog, radioChild;
    RadioButton radioCow, radioCat, radioGoat;
    Button submitBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);

        radioFarmer = findViewById(R.id.radioFarmer);
        radioDog = findViewById(R.id.radioDog);
        radioChild = findViewById(R.id.radioChild);

        radioCow = findViewById(R.id.radioCow);
        radioCat = findViewById(R.id.radioCat);
        radioGoat = findViewById(R.id.radioGoat);

        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Question 1 Answer
                int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                if (selectedId1 == radioFarmer.getId()) {
                    Toast.makeText(marathi.this, "बरोबर! शेतकरी आहे.", Toast.LENGTH_SHORT).show();
                } else {
                        Toast.makeText(marathi.this, "चुकीचे उत्तर.", Toast.LENGTH_SHORT).show();
                }

                // Question 2 Answer
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                if (selectedId2 == radioCow.getId() || selectedId2 == radioGoat.getId()) {
                    Toast.makeText(marathi.this, "योग्य प्राणी निवडले.", Toast.LENGTH_SHORT).show();
                } else {
                        Toast.makeText(marathi.this, "चुकीचा प्राणी निवडला.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
