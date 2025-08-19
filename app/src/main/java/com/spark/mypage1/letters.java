package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.letters;


public class letters extends AppCompatActivity {

    ToggleButton toggleGanpati, toggleKekada, toggleKadai, toggleTalvar, toggleGhar;
    Button buttonSubmit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure XML filename is correct

        // Link views
        toggleGanpati = findViewById(R.id.toggleganpati);
        toggleKekada = findViewById(R.id.togglekekada);
        toggleKadai = findViewById(R.id.toggleKadai);
        toggleTalvar = findViewById(R.id.toggletalvar);
        toggleGhar = findViewById(R.id.toggleghar);
        buttonSubmit = findViewById(R.id.my_button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isGanpati = toggleGanpati.isChecked();
                boolean isKekada = toggleKekada.isChecked();
                boolean isKadai = toggleKadai.isChecked();  // ✅ correct one
                boolean isTalvar = toggleTalvar.isChecked();
                boolean isGhar = toggleGhar.isChecked();

                int count = 0;
                if (isGanpati) count++;
                if (isKekada) count++;
                if (isKadai) count++;
                if (isTalvar) count++;
                if (isGhar) count++;

                // Correct condition: only कडई is selected
                if (isKadai && count == 1) {
                    Toast.makeText(letters.this, "बरोबर! ✅", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(letters.this, "चुकीचे उत्तर ❌\nकृपया पुन्हा प्रयत्न करा.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
