package com.spark.mypage1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.ClipData;
import android.content.ClipDescription;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class zzzz extends AppCompatActivity {

    ImageView imageKavla, imageSasa, imageMath, imageBhendi;
    TextView targetKavla, targetSasa, targetMath, targetBhendi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zzzz);

        imageKavla = findViewById(R.id.image_kavla);
        imageSasa = findViewById(R.id.image_sasa);
        imageMath = findViewById(R.id.image_math);
        imageBhendi = findViewById(R.id.image_bhendi);

        targetKavla = findViewById(R.id.target_kavla);
        targetSasa = findViewById(R.id.target_sasa);
        targetMath = findViewById(R.id.target_math);
        targetBhendi = findViewById(R.id.target_bhendi);

        setDragListeners(imageKavla);
        setDragListeners(imageSasa);
        setDragListeners(imageMath);
        setDragListeners(imageBhendi);

        setDropListeners(targetKavla);
        setDropListeners(targetSasa);
        setDropListeners(targetMath);
        setDropListeners(targetBhendi);
    }

    private void setDragListeners(ImageView imageView) {
        imageView.setOnLongClickListener(view -> {
            ClipData.Item item = new ClipData.Item((String) view.getTag());
            ClipData dragData = new ClipData(
                    (CharSequence) view.getTag(),
                    new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                    item);
            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
            view.startDragAndDrop(dragData, myShadow, view, 0);
            return true;
        });
    }

    @SuppressLint("SetTextI18n")
    private void setDropListeners(TextView targetView) {
        targetView.setOnDragListener((view, event) -> {
            switch (event.getAction()) {
                case DragEvent.ACTION_DROP:
                    ClipData.Item item = event.getClipData().getItemAt(0);
                    String draggedTag = item.getText().toString();
                    String targetTag = (String) view.getTag();

                    if (draggedTag.equals(targetTag)) {
                        Toast.makeText(this, "योग्य जुळवणी!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "चुकिचे आहे, पुन्हा प्रयत्न करा.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            return true;
        });
    }
}
