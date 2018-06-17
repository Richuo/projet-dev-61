package com.example.richard.dev01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;



public class AffichageImage extends AppCompatActivity {

    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;

    private ImageView horaires_mairie; //999
    private ImageView horaires_fort; //998





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_affichage);

        horaires_mairie = findViewById(R.id.imageView_mairie);

        horaires_fort = findViewById(R.id.imageView_fort);


        /// Change le layout en fonction de la carte demandée ///

        //Vers la mairie
        if (MapsActivity.id_batiment == 999) {
            horaires_mairie.setVisibility(View.VISIBLE);
            mImageView = horaires_mairie;
        }

        //Vers le Fort
        else if (MapsActivity.id_batiment == 998) {
            horaires_fort.setVisibility(View.VISIBLE);
            mImageView = horaires_fort;
        }


        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(1.0f,
                    Math.min(mScaleFactor, 5.0f));
            mImageView.setScaleX(mScaleFactor);
            mImageView.setScaleY(mScaleFactor);
            return true;
        }
    }
}
