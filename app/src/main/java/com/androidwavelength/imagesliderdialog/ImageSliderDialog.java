package com.androidwavelength.imagesliderdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class ImageSliderDialog extends Dialog {

    public interface onImageSliderExpired {
        void onImageSliderExpired();
    }

    private OnImageSliderExpired onImageSliderExpired;

    public void setOnImageSliderExpired(OnImageSliderExpired onImageSliderExpired) {
        this.onImageSliderExpired = onImageSliderExpired;
    }

    private ImageSliderThread imageSliderThread;

    private ImageView image;

    public ImageSliderDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.image_slider_dialog);
        initViews();
    }

    void setImageSlider() {

        imageSliderThread = new ImageSliderThread();
        imageSliderThread.execute((Object)null);
    }

    private void initViews() {
        image = findViewById(R.id.image);
    }

    private void updateImage() {
    }


    private class ImageSliderThread extends AsyncTask<Object, Integer, Object> {

       /* private int[] imageResources = {
                R.drawable.aurora;
                R.drawable.goldengatebridge;
                R.drawable.milkyway;
                R.drawable.rootbridge;
                R.drawable.bioluminescence;
        };

        private int currentIndex = 0;*/

        private boolean state =  true;

        public void setState(boolean state) {
            this.state = state;
        }

        @Override
        protected Object doInBackground(Object... objects) {
            while (state) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(null);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateImage();
        }
    }
}