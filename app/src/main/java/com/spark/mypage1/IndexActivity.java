package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
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

        CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(this, listGroupTitles, listChildData);
        expandableListView.setAdapter(adapter);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down));


        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (groupPosition == 0) {
                // भाग १
                switch (childPosition) {
                    case 0:
                        startActivity(new Intent(IndexActivity.this, QuizActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(IndexActivity.this, TracingActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(IndexActivity.this, newp.class));
                        break;
                    case 3:
                        startActivity(new Intent(IndexActivity.this, zzzz.class));
                        break;

                    case 4:
                        startActivity(new Intent(IndexActivity.this, TraceExerciseActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(IndexActivity.this, vacha.class));
                        break;

                    case 6:
                        startActivity(new Intent(IndexActivity.this, ExerciseSohamActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(IndexActivity.this, nnnnp.class));
                        break;
                    case 8:
                        startActivity(new Intent(IndexActivity.this, BarakhadiTracingActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(IndexActivity.this, Lesson19IncompleteActivity.class));
                        break;


                    default:
                        Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if (groupPosition == 1) {
                // भाग २
                switch (childPosition) {



                    case 0:
                        startActivity(new Intent(IndexActivity.this, CleverMouseActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(IndexActivity.this, BhoplaQuizActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(IndexActivity.this, ritupoem.class));
                        break;
                    case 3:
                        startActivity(new Intent(IndexActivity.this, Lesson21QuizActivity.class));
                        break;


                    default:
                        Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if (groupPosition == 2) {
                // भाग ३
                switch (childPosition) {
                    case 0:
                        startActivity(new Intent(IndexActivity.this, reading.class));
                        break;
                    case 1:
                        startActivity(new Intent(IndexActivity.this, exerciseActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(IndexActivity.this, ExercisePome2Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(IndexActivity.this, vp4.class));
                        break;
                    case 4:
                        startActivity(new Intent(IndexActivity.this, vp5.class));
                        break;
                    case 5:
                        startActivity(new Intent(IndexActivity.this, vp6.class));
                        break;
                    default:
                        Toast.makeText(this, "लवकरच उपलब्ध होईल!", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if (groupPosition == 3) {
                // भाग ४
                switch (childPosition) {
                    case 0:
                        startActivity(new Intent(IndexActivity.this, mypage2.class));
                        break;
                    case 1:
                        startActivity(new Intent(IndexActivity.this, ritu1.class));
                        break;
                    case 2:
                        startActivity(new Intent(IndexActivity.this, shb.class));
                        break;
                    case 3:
                        startActivity(new Intent(IndexActivity.this, WordGridActivity.class));
                        break;


                    case 4:
                        startActivity(new Intent(IndexActivity.this, sound3.class));
                        break;
                    case 5:
                        startActivity(new Intent(IndexActivity.this, WordActivity.class));
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

        // Add group titles
        listGroupTitles.add("भाग १");
        listGroupTitles.add("भाग २");
        listGroupTitles.add("भाग ३");
        listGroupTitles.add("शब्दांची गंमत"); // new group

        // भाग १ lessons
        List<String> bhag1Lessons = new ArrayList<>();
        bhag1Lessons.add("पाठ १: माझ्या या दारातून");
        bhag1Lessons.add("पाठ 2: मला घरापर्यंत पोहोचव");
        bhag1Lessons.add("पाठ 3:क – मी आणि माझे कुटुंब");
        bhag1Lessons.add("पाठ 4:क – मी आणि माझी जोडी");
        bhag1Lessons.add("पाठ 5: टिपके जोड़ व गिरव");
        bhag1Lessons.add("पाठ 6: ए आई मला पावसात जाऊ दे");
        bhag1Lessons.add("पाठ 7: सोहमचा दिवस");
        bhag1Lessons.add("पाठ 8:  राधाचे कुटुंब");
        bhag1Lessons.add("पाठ 9: भरखडी");
        bhag1Lessons.add("पाठ 10: रबित आणि डोंगर");


        // भाग २ lessons
        List<String> bhag2Lessons = new ArrayList<>();
       ;


        bhag2Lessons.add("पाठ 8: चतुर उंदीर");
        bhag2Lessons.add("पाठ 7: भोपळा");
        bhag2Lessons.add("पाठ 8: poem");
        bhag2Lessons.add("पाठ 8: majisuhbati");


        // भाग ३ lessons
        List<String> bhag3Lessons = new ArrayList<>();
        bhag3Lessons.add(" वाचनपाठ - १");
        bhag3Lessons.add(" वाचनपाठ - २ ");
        bhag3Lessons.add(" वाचनपाठ - ३");
        bhag3Lessons.add(" वाचनपाठ - 4");
        bhag3Lessons.add(" वाचनपाठ - 5 ");
        bhag3Lessons.add(" वाचनपाठ - 6 ");

        // भाग ४ lessons
        List<String> bhag4Lessons = new ArrayList<>();
        bhag4Lessons.add("गंमत1");
        bhag4Lessons.add("गंमत2");
        bhag4Lessons.add("गंमत3");
        bhag4Lessons.add("गंमत4");
        bhag4Lessons.add("गंमत5");
        bhag4Lessons.add("गंमत6");
        // Mapping groups with their lessons
        listChildData.put(listGroupTitles.get(0), bhag1Lessons);
        listChildData.put(listGroupTitles.get(1), bhag2Lessons);
        listChildData.put(listGroupTitles.get(2), bhag3Lessons);
        listChildData.put(listGroupTitles.get(3), bhag4Lessons); // new mapping
    }
}
