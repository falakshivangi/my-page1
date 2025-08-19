package com.spark.mypage1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.spark.mypage1.FamilyTreeActivity;

import java.io.IOException;

public class FamilyTreeActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    ImageView[] imageBoxes;
    int selectedBoxIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] ids = new int[]{
                R.id.box1, R.id.box2, R.id.box3,
                R.id.box4, R.id.box5, R.id.girlBox, R.id.boyBox
        };

        imageBoxes = new ImageView[ids.length];
        for (int i = 0; i < ids.length; i++) {
            imageBoxes[i] = findViewById(ids[i]);
            final int index = i;
            imageBoxes[i].setOnClickListener(v -> {
                selectedBoxIndex = index;
                openImagePicker();
            });
        }
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                if (selectedBoxIndex != -1) {
                    imageBoxes[selectedBoxIndex].setImageBitmap(bitmap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
