package com.androidwavelength.imagesliderdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected ImageSliderDialog imageSliderDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showImageSliderDialog();
    }

    protected void showImageSliderDialog() {
        imageSliderDialog = new ImageSliderDialog(this);
        imageSliderDialog.show();
    }

    private class MyOnImageSliderExpired implements ImageSliderDialog.OnImageSliderExpired {
        @Override
        public void onImageSliderExpired() {

        }
    }
}