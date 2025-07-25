package com.spark.mypage1;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class TracingActivity extends AppCompatActivity {

    TracingView tracingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trace2);

        tracingView = findViewById(R.id.tracingView);

        // Set the background image for tracing
        tracingView.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.tracing));
    }
}

