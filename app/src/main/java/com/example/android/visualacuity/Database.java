package com.example.android.visualacuity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class Database extends AppCompatActivity {
    EditText firstName, lastName, aadharNumber, age;
    Button saveInfo;
    Spinner gen;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        firstName = findViewById(R.id.txt_first_name);
        lastName = findViewById(R.id.txt_last_name);
        aadharNumber = findViewById(R.id.txt_user_id);
        age = findViewById(R.id.txt_user_age);
        saveInfo = findViewById(R.id.bn_save);
        gen = findViewById(R.id.spinner_gender);
        database = FirebaseDatabase.getInstance().getReference();


        saveInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                User();

            }
        });


    }
    private void User()
    {
        String firstname = firstName.getText().toString().trim();
        String lastname = lastName.getText().toString().trim();
        String userid = aadharNumber.getText().toString().trim();
        String userAge = age.getText().toString().trim();
        String gender = gen.getSelectedItem().toString();

        if(firstName.getText().toString().trim().length() == 0 )
        {
            Toast.makeText(this,"Enter Your First Name",Toast.LENGTH_LONG).show();
        }
        if (lastName.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this,"Enter Your Last Name",Toast.LENGTH_LONG).show();
        }
        else if(aadharNumber.getText().toString().trim().length() != 10)
        {
            Toast.makeText(this,"Enter valid Aadhar number",Toast.LENGTH_LONG).show();
        }
        else if (age.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this,"Enter Your Age",Toast.LENGTH_LONG).show();
        }



        else
        {
            @NotNull
            String uid = database.push().getKey();
            user user = new user(uid, userid, firstname, lastname, userAge, gender);
            database.child(uid).setValue(user);
            Toast.makeText(this, "User Added....", Toast.LENGTH_LONG).show();

        }

    }
}
