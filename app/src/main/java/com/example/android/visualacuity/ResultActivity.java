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
                if (Rsnellen.getText() == myIntent.getStringExtra("Rsnellen6")) {
                    Rsnellen.setText(myIntent.getStringExtra("Rsnellen20"));
                    Runitchange.setText("Imperial");
                } else if (Rsnellen.getText() == myIntent.getStringExtra("Rsnellen20")) {
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

////        Bundle params = new Bundle();
//        double logMARValue = myIntent.getDoubleExtra("logMAR", 0.00);
////        double logMARValue = params.getDouble("logMAR");
//        String r = "Snellen (6m): " + myIntent.getStringExtra("Snellen6") + "\n"
//                    + "Snellen (20ft): " + myIntent.getStringExtra("Snellen20") + "\n"
//                    + "LogMAR: " + logMARValue;
//        resultView.setText(r);



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
