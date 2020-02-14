package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public Button retake,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final TextView Lsnellen = findViewById(R.id.Lsnellen);
        final TextView Rsnellen = findViewById(R.id.Rsnellen);
        TextView Llogmar = findViewById(R.id.Llogmar);
        TextView Rlogmar = findViewById(R.id.Rlogmar);

        final Intent myIntent = getIntent();
        Rsnellen.setText(HomeActivity.s6[0]);
        Lsnellen.setText(HomeActivity.s6[1]);
        Rlogmar.setText(Double.toString(HomeActivity.logMAR[0]));
        Llogmar.setText(Double.toString(HomeActivity.logMAR[1]));

        final TextView Runitchange = findViewById(R.id.RUnitchange);
        final TextView Lunitchange = findViewById(R.id.LUnitchange);

        Runitchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rsnellen.getText()==HomeActivity.s6[0])
                {
                    Rsnellen.setText(HomeActivity.s20[0]);
                    Runitchange.setText("Imperial");
                }
                else if(Rsnellen.getText()==HomeActivity.s20[0]) {
                    Rsnellen.setText(HomeActivity.s6[0]);
                    Runitchange.setText("Metric");
                }

                if(Lsnellen.getText()==HomeActivity.s6[1])
                {
                    Lsnellen.setText(HomeActivity.s20[1]);
                    Lunitchange.setText("Imperial");
                }
                else if(Lsnellen.getText()==HomeActivity.s20[1]) {
                    Lsnellen.setText(HomeActivity.s6[1]);
                    Lunitchange.setText("Metric");
                }
            }
        });
        Lunitchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rsnellen.getText()==HomeActivity.s6[0])
                {
                    Rsnellen.setText(HomeActivity.s20[0]);
                    Runitchange.setText("Imperial");
                }
                else if(Rsnellen.getText()==HomeActivity.s20[0]) {
                    Rsnellen.setText(HomeActivity.s6[0]);
                    Runitchange.setText("Metric");
                }

                if(Lsnellen.getText()==HomeActivity.s6[1])
                {
                    Lsnellen.setText(HomeActivity.s20[1]);
                    Lunitchange.setText("Imperial");
                }
                else if(Lsnellen.getText()==HomeActivity.s20[1]) {
                    Lsnellen.setText(HomeActivity.s6[1]);
                    Lunitchange.setText("Metric");
                }

            }
        });
        /*
        final Intent myIntent = getIntent();
        double[] logMARValue =new double[] {myIntent.getDoubleExtra("RlogMAR", 0.00),myIntent.getDoubleExtra("LlogMAR", 0.00)};
        Rsnellen.setText(myIntent.getStringExtra("Rsnellen6"));
        Lsnellen.setText(myIntent.getStringExtra("Lsnellen6"));
        Rlogmar.setText(Double.toString(logMARValue[0]));
        Llogmar.setText(Double.toString(logMARValue[1]));
        final TextView Runitchange = findViewById(R.id.RUnitchange);
        final TextView Lunitchange = findViewById(R.id.LUnitchange);
        Runitchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rsnellen.getText()==myIntent.getStringExtra("Rsnellen6"))
                {
                    Rsnellen.setText(myIntent.getStringExtra("Rsnellen20"));
                    Runitchange.setText("Imperial");
                }
                else if(Rsnellen.getText()==myIntent.getStringExtra("Rsnellen20")) {
                    Rsnellen.setText(myIntent.getStringExtra("Rsnellen6"));
                    Runitchange.setText("Metric");
                }
                if(Lsnellen.getText()==myIntent.getStringExtra("Lsnellen6")) {
                    Lsnellen.setText(myIntent.getStringExtra("Lsnellen20"));
                    Lunitchange.setText("Imperial");
                }
                else if(Lsnellen.getText()==myIntent.getStringExtra("Lsnellen20"))
                {
                    Lsnellen.setText(myIntent.getStringExtra("Lsnellen6"));
                    Lunitchange.setText("Metric");
                }
            }
        });
        Lunitchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Lsnellen.getText()==myIntent.getStringExtra("Lsnellen6")) {
                    Lsnellen.setText(myIntent.getStringExtra("Lsnellen20"));
                    Lunitchange.setText("Imperial");
                }
                else if(Lsnellen.getText()==myIntent.getStringExtra("Lsnellen20"))
                {
                    Lsnellen.setText(myIntent.getStringExtra("Lsnellen6"));
                    Lunitchange.setText("Metric");
                }
                if(Rsnellen.getText()==myIntent.getStringExtra("Rsnellen6"))
                {
                    Rsnellen.setText(myIntent.getStringExtra("Rsnellen20"));
                    Runitchange.setText("Imperial");
                }
                else if(Rsnellen.getText()==myIntent.getStringExtra("Rsnellen20")) {
                    Rsnellen.setText(myIntent.getStringExtra("Rsnellen6"));
                    Runitchange.setText("Metric");
                }
            }
        });
        */
        retake = findViewById(R.id.retake);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ResultActivity.this,InstructionActivity.class);
                ResultActivity.this.startActivity(mainIntent);
                ResultActivity.this.finish();
            }
        });

        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ResultActivity.this,AddResult.class);
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
