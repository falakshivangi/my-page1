package com.spark.mypage1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class shb extends AppCompatActivity {

    EditText wordA1, wordA2, wordA3, wordA4;
    EditText wordE1, wordE2, wordE3, wordE4;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shb);

        wordA1 = findViewById(R.id.wordA1);
        wordA2 = findViewById(R.id.wordA2);
        wordA3 = findViewById(R.id.wordA3);
        wordA4 = findViewById(R.id.wordA4);

        wordE1 = findViewById(R.id.wordE1);
        wordE2 = findViewById(R.id.wordE2);
        wordE3 = findViewById(R.id.wordE3);
        wordE4 = findViewById(R.id.wordE4);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aWords = wordA1.getText().toString() + ", " +
                        wordA2.getText().toString() + ", " +
                        wordA3.getText().toString() + ", " +
                        wordA4.getText().toString();

                String eWords = wordE1.getText().toString() + ", " +
                        wordE2.getText().toString() + ", " +
                        wordE3.getText().toString() + ", " +
                        wordE4.getText().toString();

                Toast.makeText(shb.this,
                        "शेवटी 'ा' येणारे शब्द: " + aWords + "\n" +
                                "शेवटी 'ई' येणारे शब्द: " + eWords,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
