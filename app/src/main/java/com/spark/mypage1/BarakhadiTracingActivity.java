package com.spark.mypage1;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.barakhadi); // ✅ Use correct layout

        // Bind views
        letterText = findViewById(R.id.letterText);
        drawingView = findViewById(R.id.drawingView);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);
        clearBtn = findViewById(R.id.clearBtn);

        // Get Vyanjan from intent
        String vyanjan = getIntent().getStringExtra("VANJAN");
        if (vyanjan == null) vyanjan = "क"; // default

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