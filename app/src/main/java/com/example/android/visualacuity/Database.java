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
    EditText fname,lname,aadhar_number,age;
    Button save_info;
    Spinner gen;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        fname= findViewById(R.id.txt_first_name);
        lname=findViewById(R.id.txt_last_name);
        aadhar_number= findViewById(R.id.txt_user_id);
        age= findViewById(R.id.txt_user_age);
        save_info= findViewById(R.id.bn_save);
        gen=findViewById(R.id.spinner_gender);
        database= FirebaseDatabase.getInstance().getReference();


        save_info.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                User();

            }
        });


    }
    private void User()
    {
        String firstname=fname.getText().toString().trim();
        String lastname=lname.getText().toString().trim();
        String userid=aadhar_number.getText().toString().trim();
        String userage=age.getText().toString().trim();
        String gender=gen.getSelectedItem().toString();

        if(firstname.matches(" "))
        {
            Toast.makeText(this,"Enter Your Name",Toast.LENGTH_LONG).show();
        }
        else if (lastname.matches(" "))
        {
            Toast.makeText(this,"Enter Your Name",Toast.LENGTH_LONG).show();
        }
        else if(userid.matches(" "))
        {
            Toast.makeText(this,"Enter valid Aadhar number",Toast.LENGTH_LONG).show();
        }
        else if (userage.matches(" "))
        {
            Toast.makeText(this,"Enter Your Age",Toast.LENGTH_LONG).show();
        }



        else
        {
            @NotNull
            String uid=database.push().getKey();
            user user=new user(uid,userid,firstname,lastname,userage,gender);
            database.child(uid).setValue(user);
            Toast.makeText(this, "User Added....", Toast.LENGTH_LONG).show();

        }

    }
}
