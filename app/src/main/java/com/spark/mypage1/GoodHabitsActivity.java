package com.spark.mypage1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GoodHabitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changalisavi);

        // Wake Up
        ImageView imgWake = findViewById(R.id.imgWake);
        Button btnWake = findViewById(R.id.btnWake);
        btnWake.setOnClickListener(v -> {
            imgWake.setImageResource(R.drawable.img_1);
            Toast.makeText(this, "शाब्बास! लवकर उठलात ☀️", Toast.LENGTH_SHORT).show();
        });

        // Brush Teeth
        ImageView imgBrush = findViewById(R.id.imgBrush);
        Button btnBrush = findViewById(R.id.btnBrush);
        btnBrush.setOnClickListener(v -> {
            imgBrush.setImageResource(R.drawable.img_5);
            Toast.makeText(this, "दात स्वच्छ झाले 😁", Toast.LENGTH_SHORT).show();
        });

        // Eat Healthy
        ImageView imgEat = findViewById(R.id.imgEat);
        Button btnEat = findViewById(R.id.btnEat);
        btnEat.setOnClickListener(v -> {
            imgEat.setImageResource(R.drawable.img_6);
            Toast.makeText(this, "संतुलित आहार घेतला 🍎🥦", Toast.LENGTH_SHORT).show();
        });

        // Drink Water
        ImageView imgDrink = findViewById(R.id.imgDrink);
        Button btnDrink = findViewById(R.id.btnDrink);
        btnDrink.setOnClickListener(v -> {
            imgDrink.setImageResource(R.drawable.img_7);
            Toast.makeText(this, "पाणी प्यायलात 💧", Toast.LENGTH_SHORT).show();
        });

        // Keep Books & Toys
        ImageView imgBooks = findViewById(R.id.imgBooks);
        Button btnBooks = findViewById(R.id.btnBooks);
        btnBooks.setOnClickListener(v -> {
            imgBooks.setImageResource(R.drawable.img_8);
            Toast.makeText(this, "वा! पुस्तके आणि खेळणी आवरली 📚🧸", Toast.LENGTH_SHORT).show();
        });
    }
}
