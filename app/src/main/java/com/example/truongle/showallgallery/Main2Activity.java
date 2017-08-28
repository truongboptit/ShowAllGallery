package com.example.truongle.showallgallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView= (ImageView) findViewById(R.id.imageViewFullScreen);
        Intent intent = getIntent();
        String imagePath= intent.getStringExtra("imagePath");
        Glide.with(getApplicationContext()).load(imagePath).into(imageView);
    }
}
