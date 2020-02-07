package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.github.pwittchen.swipe.library.rx2.SwipeListener;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity {
    private Swipe swipe;
    public Button wrong;
    public Integer r = 0, swipeDirection = 0, flag = 0;
    public Integer rotationCount = 0;
    public Integer i = 0;
    public Integer cantSeeFlag = 0;
    public double logMAR = 1.00;
    public double[] dividend = new double[]{60, 48, 38, 30, 24, 19, 15, 12, 9.5, 7.5, 6};
    public int[] feetDividend = new int[] {200, 160, 125, 100, 80, 63, 50, 40, 32, 25, 20};
    public double[] logMARList = new double[]{1.00, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.0};
    public int[] imageList = new int[]{R.drawable.ic_e_29, R.drawable.ic_e_23, R.drawable.ic_e_18,
                        R.drawable.ic_e_14, R.drawable.ic_e_11, R.drawable.ic_e_9, R.drawable.ic_e_7,
                        R.drawable.ic_e_5, R.drawable.ic_e_4, R.drawable.ic_e_3, R.drawable.ic_e_2};    //11 images added to list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //For vibration on swipe
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //Max Brightness
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1F;
        getWindow().setAttributes(layout);//End

//        final ViewFlipper viewFlipper = findViewById(R.id.ViewFlipper);

        wrong = findViewById(R.id.wrong);
        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantSeeFlag=1;
                result();
            }
        });

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
                rotationCount++;
                v.vibrate(100);
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
                rotationCount++;
                v.vibrate(100);
                rotation();
                return true;

            }

            @Override public void onSwipingUp(final MotionEvent event) {
                //info.setText("SWIPING_UP");
            }

            @Override public boolean onSwipedUp(final MotionEvent event) {
                //info.setText("SWIPED_UP");
                swipeDirection=3;
                rotationCount++;
                v.vibrate(100);
                rotation();
                return true;
            }

            @Override public void onSwipingDown(final MotionEvent event) {
                //info.setText("SWIPING_DOWN");
            }

            @Override public boolean onSwipedDown(final MotionEvent event) {
                //info.setText("SWIPED_DOWN");
                swipeDirection=1;
                rotationCount++;
                v.vibrate(100);
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
        if(rotationCount > 4)
        {
            rotationCount = 0;
            i++;
            flag = 0;
            logMAR = 0;
        }
        final ImageView imgview;
        imgview = findViewById(R.id.imageView1);
        if(i<11) {      // To avoid ArrayOutOfBounds error, this condition is required
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Random rand = new Random();
                    r = rand.nextInt(4);
                    imgview.setImageResource(imageList[i]);       // Image changes on every swipe
                    imgview.setRotation((float) 90.0 * r);
                }
            }, 400);
        }
        else {
            i = 10;
            result();
        }

    }

    public void result(){
        if(swipeDirection != r){
            flag++;
            rotationCount--;
        }

        if(flag>2 || (i==10 && rotationCount>4) || cantSeeFlag==1){
            String s6 = "6/" + (int)dividend[i] + " - " + flag;
            String s20 = "20/" + feetDividend[i] + " - " + flag;
            logMAR = logMARList[i] + (0.02 * flag);
            logMAR = Math.round(logMAR * 10000d) / 10000d;
            Intent myIntent = new Intent(HomeActivity.this, ResultActivity.class);
            myIntent.putExtra("Snellen6", s6);
            myIntent.putExtra("Snellen20", s20);
            myIntent.putExtra("logMAR", logMAR);
            startActivity(myIntent);
        }
    }

    @Override
    public void onBackPressed() {
        //Do nothing
        Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
        HomeActivity.this.startActivity(mainIntent);
        HomeActivity.this.finish();
    }
}
