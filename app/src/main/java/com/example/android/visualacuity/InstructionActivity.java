package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.text.MessageFormat.format;

public class InstructionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        Button next_button = findViewById(R.id.next);

        TextView instruction1 = findViewById(R.id.instruction1);
        TextView instruction2 = findViewById(R.id.instruction2);
        TextView instruction3 = findViewById(R.id.instruction3);
        TextView instruction4 = findViewById(R.id.instruction4);

        String s1 =  getString(R.string.instruction1);
        instruction1.setText(getSpannedText(s1));

        String s2 = getString(R.string.instruction2);
        instruction2.setText(getSpannedText(s2));

        String s3 = getString(R.string.instruction3);
        instruction3.setText(getSpannedText(s3));

        String s4 = getString(R.string.instruction4);
        instruction4.setText(getSpannedText(s4));

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(InstructionActivity.this,HomeActivity.class);
                InstructionActivity.this.startActivity(mainIntent);
                InstructionActivity.this.finish();
            }
        });

    }

    private Spanned getSpannedText(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(text);
        }
    }

}
