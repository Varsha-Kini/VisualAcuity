package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultView = findViewById(R.id.resultView);
        Intent myIntent = getIntent(); // this is just for example purpose
        String r=myIntent.getStringExtra("key");
        resultView.setText(r);
    }
}
