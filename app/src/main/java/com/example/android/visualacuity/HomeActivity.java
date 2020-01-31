package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.github.pwittchen.swipe.library.rx2.SwipeListener;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    private Swipe swipe;
    public int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Max Brightness
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F;
        getWindow().setAttributes(layout);//End

        final ViewFlipper viewFlipper = findViewById(R.id.ViewFlipper);

        swipe = new Swipe();
        swipe.setListener(new SwipeListener() {
            @Override public void onSwipingLeft(final MotionEvent event) {
                //info.setText("SWIPING_LEFT");
                //viewFlipper.showPrevious();
            }

            @Override public boolean onSwipedLeft(final MotionEvent event) {
                //info.setText("SWIPED_LEFT");
                //viewFlipper.showNext();
                rotation();
                return true;
            }

            @Override public void onSwipingRight(final MotionEvent event) {
                //info.setText("SWIPING_RIGHT");
                //viewFlipper.showNext();
            }

            @Override public boolean onSwipedRight(final MotionEvent event) {
                //info.setText("SWIPED_RIGHT");
                viewFlipper.showNext();
                return true;

            }

            @Override public void onSwipingUp(final MotionEvent event) {
                //info.setText("SWIPING_UP");
            }

            @Override public boolean onSwipedUp(final MotionEvent event) {
                //info.setText("SWIPED_UP");
                viewFlipper.showNext();
                return true;
            }

            @Override public void onSwipingDown(final MotionEvent event) {
                //info.setText("SWIPING_DOWN");
            }

            @Override public boolean onSwipedDown(final MotionEvent event) {
                //info.setText("SWIPED_DOWN");
                viewFlipper.showPrevious();
                return true;
            }
        });
    }
    public void rotation(){
        Random rand = new Random();
        r=rand.nextInt(4);
        ImageView imgview;
        imgview = (ImageView)findViewById(R.id.imageView1);
        imgview.setRotation((float) 90.0*r);
    }


    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }
}
