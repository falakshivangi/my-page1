package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.TracingActivity;

public class TracingActivity extends AppCompatActivity {

    View tracingView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trace);

        // Make sure trace.xml has a View/ImageView with id 'tracingView'
        tracingView = findViewById(R.id.tracingView);

        // Set background or image
        tracingView.setBackgroundResource(R.drawable.tracing);
        // If it's an ImageView, use:
        // ((ImageView) tracingView).setImageResource(R.drawable.tracing);
    }
}
