package com.spark.mypage1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class IndexActivity extends AppCompatActivity {

    ListView lessonListView;

    String[] lessons = {
            "पाठ १: माझ्या या दारातून",
            "पाठ ३: वाचनपाठ - १ (काका आला, मामा आला)",
            "पाठ ४: वाचनपाठ - २ (घार आली घार)",
            "पाठ ५: वाचनपाठ - ३ (आला आला पाऊस आला)",
            "पाठ ६: मला घरापर्यंत पोहोचव",
            "पाठ ७: टिपके जोड़ व गिरव",
            "पाठ ८: ए आई मला पावसात जाऊ दे",
            "पाठ ९: शब्द तयार कर व लिही",
            "पाठ १०: सोहमचा दिवस",
            "पाठ ११: z (ट्रेसिंग)",
            "पाठ १२: चतुर उंदीर",
            "पाठ १३: भोपळा",
            "पाठ 14: priya vp"  , // ✅ New Lesson Added
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage);

        lessonListView = findViewById(R.id.lessonListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lessons);
        lessonListView.setAdapter(adapter);

        lessonListView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    startActivity(new Intent(IndexActivity.this, QuizActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(IndexActivity.this, reading.class));
                    break;
                case 2:
                    startActivity(new Intent(IndexActivity.this, exerciseActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(IndexActivity.this, ExercisePome2Activity.class));
                    break;
                case 4:
                    startActivity(new Intent(IndexActivity.this, TracingActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(IndexActivity.this, TraceExerciseActivity.class));
                    break;
                case 6:
                    startActivity(new Intent(IndexActivity.this, vacha.class));
                    break;
                case 7:
                    startActivity(new Intent(IndexActivity.this, WordActivity.class));
                    break;
                case 8:
                    startActivity(new Intent(IndexActivity.this, ExerciseSohamActivity.class));
                    break;
                case 9:
                    startActivity(new Intent(IndexActivity.this, TracingActivity.class));
                    break;
                case 10:
                    startActivity(new Intent(IndexActivity.this, CleverMouseActivity.class)); // ✅ चतुर उंदीर
                    break;
                case 11:
                    startActivity(new Intent(IndexActivity.this, BhoplaQuizActivity.class)); // ✅ New भोपळा Activity
                    break;
                    case 12:
                    startActivity(new Intent(IndexActivity.this, GhaarExerciseActivity.class)); // ✅ New भोपळा Activity
                    break;


                default:
                    Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}