package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lesson19IncompleteActivity extends AppCompatActivity {

    EditText editAnswer;
    Button btnSubmit;
    TextView textShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabit);

        editAnswer = findViewById(R.id.editAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
        textShowAnswer = findViewById(R.id.textShowAnswer);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = editAnswer.getText().toString().trim();

                if (answer.isEmpty()) {
                    Toast.makeText(Lesson19IncompleteActivity.this, "कृपया उत्तर लिहा", Toast.LENGTH_SHORT).show();
                } else {
                    textShowAnswer.setText("तुमचे उत्तर:\n" + answer);
                    textShowAnswer.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
