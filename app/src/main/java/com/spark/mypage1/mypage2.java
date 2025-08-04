package com.spark.mypage1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mypage2 extends Activity {

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the correct layout
        setContentView(R.layout.mypage2); // Make sure this XML file exists

        // Link the button from XML
        nextButton = findViewById(R.id.my_button); // Make sure ID matches the XML

        if (nextButton != null) {
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Action on button click
                    Intent i = new Intent(mypage2.this, mypage2.class); // Replace with your next activity
                    startActivity(i);
                }
            });
        } else {
            // Log or debug if it's still null
            System.out.println("Button not found - Check ID or layout used");
        }
    }
}
