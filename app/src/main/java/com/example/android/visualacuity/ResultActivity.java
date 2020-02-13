package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public Button retake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultView = findViewById(R.id.snellenleftvalue);
        Intent myIntent = getIntent(); // this is just for example purpose

//        Bundle params = new Bundle();
        double logMARValue = myIntent.getDoubleExtra("logMAR", 0.00);
//        double logMARValue = params.getDouble("logMAR");
        String r = "Snellen (6m): " + myIntent.getStringExtra("Snellen6") + "\n"
                    + "Snellen (20ft): " + myIntent.getStringExtra("Snellen20") + "\n"
                    + "LogMAR: " + logMARValue;
        resultView.setText(r);

        retake = findViewById(R.id.retake);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ResultActivity.this,InstructionActivity.class);
                ResultActivity.this.startActivity(mainIntent);
                ResultActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(ResultActivity.this,MainActivity.class);
        ResultActivity.this.startActivity(mainIntent);
        ResultActivity.this.finish();
    }
}
