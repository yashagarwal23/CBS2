package com.example.cbs2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CropCheckStatusResult extends AppCompatActivity {

    ImageView cropPhotoImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_check_status_result);

        Intent startIntent = getIntent();
        Bundle extras = startIntent.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("image");

        cropPhotoImageview = (ImageView)findViewById(R.id.crop_result_imageview);
        cropPhotoImageview.setImageBitmap(imageBitmap);
    }
}
