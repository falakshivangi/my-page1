package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.BarakhadiTracingActivity;

public class BarakhadiTracingActivity extends AppCompatActivity {

    TextView letterText;
    DrawingView drawingView;
    Button nextBtn, prevBtn, clearBtn;

    String[] barakhadi;
    int currentIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barakhadi_tracing);

        // Bind views
        letterText = findViewById(R.id.letterText);
        drawingView = findViewById(R.id.drawingView);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);
        clearBtn = findViewById(R.id.clearBtn);

        // Get Vyanjan from intent (default to "क" if not provided)
        String vyanjan = getIntent().getStringExtra("VYANJAN");
        if (vyanjan == null || vyanjan.trim().isEmpty()) {
            vyanjan = "क";
        }

        // Generate barakhadi variations
        barakhadi = new String[]{
                vyanjan,
                vyanjan + "ा", vyanjan + "ि", vyanjan + "ी",
                vyanjan + "ु", vyanjan + "ू", vyanjan + "े",
                vyanjan + "ै", vyanjan + "ो", vyanjan + "ौ",
                vyanjan + "ं", vyanjan + "ः"
        };

        updateLetter();

        // Next button click
        nextBtn.setOnClickListener(v -> {
            if (currentIndex < barakhadi.length - 1) {
                currentIndex++;
                updateLetter();
            } else {
                Toast.makeText(this, "शेवटचे अक्षर!", Toast.LENGTH_SHORT).show();
            }
        });

        // Previous button click
        prevBtn.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateLetter();
            } else {
                Toast.makeText(this, "पहिले अक्षर!", Toast.LENGTH_SHORT).show();
            }
        });

        // Clear button click
        clearBtn.setOnClickListener(v -> drawingView.clear());
    }

    // Update the letter to be traced
    private void updateLetter() {
        letterText.setText(barakhadi[currentIndex]);
        drawingView.clear();
    }
}
