package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class nnnnp extends AppCompatActivity {

    EditText ans1, ans2, ans3;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nnnnp);

        // Initialize views
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        submitBtn = findViewById(R.id.submitBtn);

        // Button click event
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer1 = ans1.getText().toString().trim();
                String answer2 = ans2.getText().toString().trim();
                String answer3 = ans3.getText().toString().trim();

                // Display all answers as a toast
                String message = "उत्तर:\n1) " + answer1 + "\n2) " + answer2 + "\n3) " + answer3;
                Toast.makeText(nnnnp.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
