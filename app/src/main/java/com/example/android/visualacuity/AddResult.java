package com.example.android.visualacuity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddResult extends AppCompatActivity {
    Button save;
    EditText editText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        save = findViewById(R.id.button);
        editText = findViewById(R.id.edittxt_user_id);
        Intent i = getIntent();
        ArrayList<String> list = i.getStringArrayListExtra("key");


    }
}
