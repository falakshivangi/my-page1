package com.spark.mypage1;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CleverMouseActivity extends AppCompatActivity {

    EditText answer1, answer2, answer3;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story1);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans1 = answer1.getText().toString().trim();
                String ans2 = answer2.getText().toString().trim();
                String ans3 = answer3.getText().toString().trim();

                if (ans1.isEmpty() || ans2.isEmpty() || ans3.isEmpty()) {
                    Toast.makeText(CleverMouseActivity.this, "सर्व उत्तर लिहा!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CleverMouseActivity.this, "उत्तर सबमिट झाले!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
