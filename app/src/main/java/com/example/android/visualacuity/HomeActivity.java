package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
    public int r,swipeDirection,flag=0;
    public int rotationcount=0;
    public int i=0;
    public int[] dividend=new int[]{60,48,38,30,24,19,15,12,9,7,6};
    public int[] imageList = new int[]{R.drawable.e, R.drawable.e1};    // Two images added to list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Max Brightness
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F;
        getWindow().setAttributes(layout);//End

//        final ViewFlipper viewFlipper = findViewById(R.id.ViewFlipper);

        swipe = new Swipe();
        swipe.setListener(new SwipeListener() {
            @Override public void onSwipingLeft(final MotionEvent event) {
                //info.setText("SWIPING_LEFT");
                //viewFlipper.showPrevious();
            }

            @Override public boolean onSwipedLeft(final MotionEvent event) {
                //info.setText("SWIPED_LEFT");
                //viewFlipper.showNext();
                swipeDirection=2;
                rotationcount++;
                rotation();
                return true;
            }

            @Override public void onSwipingRight(final MotionEvent event) {
                //info.setText("SWIPING_RIGHT");
                //viewFlipper.showNext();
            }

            @Override public boolean onSwipedRight(final MotionEvent event) {
                //info.setText("SWIPED_RIGHT");
                swipeDirection=0;
                rotationcount++;
                rotation();
                return true;

            }

            @Override public void onSwipingUp(final MotionEvent event) {
                //info.setText("SWIPING_UP");
            }

            @Override public boolean onSwipedUp(final MotionEvent event) {
                //info.setText("SWIPED_UP");
                swipeDirection=3;
                rotationcount++;
                rotation();
                return true;
            }

            @Override public void onSwipingDown(final MotionEvent event) {
                //info.setText("SWIPING_DOWN");
            }

            @Override public boolean onSwipedDown(final MotionEvent event) {
                //info.setText("SWIPED_DOWN");
                swipeDirection=1;
                rotationcount++;
                rotation();
                return true;
            }
        });
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    public void rotation() {
        result();
        if(rotationcount>4)
        {
            rotationcount=0;
            i++;
            flag=0;
        }
        Random rand = new Random();
        r = rand.nextInt(4);
        ImageView imgview;
        imgview = findViewById(R.id.imageView1);
        imgview.setImageResource(imageList[i%2]);       // Image changes on every swipe
        imgview.setRotation((float) 90.0 * r);
    }

    public void result(){
        if(swipeDirection!=r){
            flag++;
            rotationcount--;
        }
        if(flag>1){
            String s="6/"+(Integer.toString(dividend[i]));
            Intent myIntent = new Intent(HomeActivity.this, ResultActivity.class);
            myIntent.putExtra("key", s);
            startActivity(myIntent);
        }
    }


}
