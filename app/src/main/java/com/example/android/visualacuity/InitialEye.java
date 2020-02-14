package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InitialEye extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_eye);
        Button next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(InitialEye.this,HomeActivity.class);
                InitialEye.this.startActivity(mainIntent);
                InitialEye.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //do nothing
        Toast.makeText(getBaseContext(), "Error: Test not completed",Toast.LENGTH_SHORT).show();
    }
}
