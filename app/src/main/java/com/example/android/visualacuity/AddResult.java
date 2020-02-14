package com.example.android.visualacuity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddResult extends AppCompatActivity {
    Button save;
    EditText editText;
    String id;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        save = findViewById(R.id.button);
        editText = findViewById(R.id.edittxt_user_id);
        Intent i = getIntent();
        ArrayList<String> list = i.getStringArrayListExtra("key");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=editText.getText().toString();

            }
        });
        for(int j=0;j<list.size();j++)
        {
            String c=list.get(j);
            if (id==c){
                Toast.makeText(this,"Entry Exists",Toast.LENGTH_LONG).show();
                break;
            }
            Toast.makeText(this,"Enter Does Not Exist",Toast.LENGTH_LONG).show();

        }

    }
}
