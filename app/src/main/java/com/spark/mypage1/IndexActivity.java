package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listGroupTitles;
    HashMap<String, List<String>> listChildData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage);

        expandableListView = findViewById(R.id.expandableListView);

        prepareListData();

        // Set the adapter
        CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(this, listGroupTitles, listChildData);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (groupPosition == 0) {
                // भाग १
                switch (childPosition) {
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
                        startActivity(new Intent(IndexActivity.this, BhoplaQuizActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(IndexActivity.this, newp.class));
                        break;
                    case 11:
                        startActivity(new Intent(IndexActivity.this, zzzz.class));
                        break;
                    default:
                        Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if (groupPosition == 1) {
                // भाग २
                switch (childPosition) {
                    case 0:
                        startActivity(new Intent(IndexActivity.this, mypage2.class));
                        break;
                    case 1:
                        startActivity(new Intent(IndexActivity.this, ritu1.class));
                        break;
                    case 2:
                        startActivity(new Intent(IndexActivity.this, WordActivity.class));
                        break;


                    case 3:
                        startActivity(new Intent(IndexActivity.this, ssp.class));
                        break;
                    case 4:
                        startActivity(new Intent(IndexActivity.this, WordGridActivity.class));
                        break;

                    case 5:
                        startActivity(new Intent(IndexActivity.this, shb.class));
                        break;
                    case 6:
                        startActivity(new Intent(IndexActivity.this, nnnnp.class));
                        break;
                    case 7:
                        startActivity(new Intent(IndexActivity.this, sound3.class));
                        break;
                    case 8:
                        startActivity(new Intent(IndexActivity.this, CleverMouseActivity.class));
                        break;
                    default:
                        Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            return true;
        });
    }

    private void prepareListData() {
        listGroupTitles = new ArrayList<>();
        listChildData = new HashMap<>();

        listGroupTitles.add("भाग १");
        listGroupTitles.add("भाग २");

        List<String> bhag1Lessons = new ArrayList<>();
        bhag1Lessons.add("पाठ १: माझ्या या दारातून");
        bhag1Lessons.add("पाठ ३: वाचनपाठ - १ (काका आला, मामा आला)");
        bhag1Lessons.add("पाठ ४: वाचनपाठ - २ (घार आली घार)");
        bhag1Lessons.add("पाठ ५: वाचनपाठ - ३ (आला आला पाऊस आला)");
        bhag1Lessons.add("पाठ ६: मला घरापर्यंत पोहोचव");
        bhag1Lessons.add("पाठ ७: टिपके जोड़ व गिरव");
        bhag1Lessons.add("पाठ ८: ए आई मला पावसात जाऊ दे");
        bhag1Lessons.add("पाठ ९: शब्द तयार कर व लिही");
        bhag1Lessons.add("पाठ १०: सोहमचा दिवस");

        bhag1Lessons.add("पाठ १२: भोपळा");
        bhag1Lessons.add("पाठ 16:क – newp");
        bhag1Lessons.add("पाठ 16:क –zzzz ");

        List<String> bhag2Lessons = new ArrayList<>();
        bhag2Lessons.add("पाठ 13: priya vp");
        bhag2Lessons.add("पाठ 14: ritu1");
        bhag2Lessons.add("पाठ 15:क – ओळखा व निवडा");


        bhag2Lessons.add("पाठ 18:क – ssp");

        bhag2Lessons.add("पाठ 21:क – shabaga");
        bhag2Lessons.add("पाठ 22:क – rada che kutumb");
        bhag2Lessons.add("पाठ 19:क – demo123");

        bhag2Lessons.add("पाठ 23:क – sound3");
        bhag2Lessons.add("पाठ ११: चतुर उंदीर");

        listChildData.put(listGroupTitles.get(0), bhag1Lessons);
        listChildData.put(listGroupTitles.get(1), bhag2Lessons);
    }
}