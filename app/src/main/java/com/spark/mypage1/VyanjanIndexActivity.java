package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class VyanjanIndexActivity extends AppCompatActivity {

    ListView vyanjanListView;
    String[] vyanjan = {
            "क", "ख", "ग", "घ", "च", "छ", "ज", "झ",
            "ट", "ठ", "ड", "ढ", "ण",
            "त", "थ", "द", "ध", "न",
            "प", "फ", "ब", "भ", "म",
            "य", "र", "ल", "व",
            "श", "ष", "स", "ह",
            "ळ", "क्ष", "ज्ञ"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use the correct layout that has the ListView
        setContentView(R.layout.activity_bharakhadi);

        vyanjanListView = findViewById(R.id.vyanjanListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, vyanjan);
        vyanjanListView.setAdapter(adapter);

        vyanjanListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedVyanjan = vyanjan[position];
            Intent intent = new Intent(VyanjanIndexActivity.this, BarakhadiTracingActivity.class);
            intent.putExtra("VYANJAN", selectedVyanjan);
            startActivity(intent);
        });
    }
}
