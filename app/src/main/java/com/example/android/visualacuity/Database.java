package com.example.android.visualacuity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import at.markushi.ui.CircleButton;
import java.util.ArrayList;

public class Database extends AppCompatActivity {
    EditText firstName, lastName, aadharNumber, age;
    static String firstname,lastname,userAge, gender,userid;
    CircleButton saveInfo;
    Spinner gen;
    private Toast errorToast;
    static DatabaseReference database;
    public static int Detailsflag=1;
    public static ArrayList<String> list= new ArrayList<>();

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
        //Intent intent = new Intent(this, AddResult.class);
        //intent.putStringArrayListExtra("key",list);

        saveInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                User();
                if(Detailsflag==0) {
                    firstName.setText("");
                    lastName.setText("");
                    aadharNumber.setText("");
                    age.setText("");
                    Detailsflag=1;
                }

            }
        });


    }
    public void User()
    {
        firstname = firstName.getText().toString().trim();
        lastname = lastName.getText().toString().trim();
        userid = aadharNumber.getText().toString().trim();
        list.add(userid);
        userAge = age.getText().toString().trim();
        gender = gen.getSelectedItem().toString();

        if(firstName.getText().toString().trim().length() == 0 )
        {
            errorToast = Toast.makeText(this,"Enter Your First Name",Toast.LENGTH_SHORT);
            errorToast.show();
            Detailsflag=1;
        }
        if (lastName.getText().toString().trim().length() == 0)
        {
            errorToast = Toast.makeText(this,"Enter Your Last Name",Toast.LENGTH_SHORT);
            errorToast.show();
            Detailsflag=1;
        }
        if(aadharNumber.getText().toString().trim().length() != 10)
        {
           errorToast = Toast.makeText(this,"Enter valid Aadhar number",Toast.LENGTH_SHORT);
            errorToast.show();
            Detailsflag=1;
        }
        if (age.getText().toString().trim().length() == 0)
        {
            errorToast = Toast.makeText(this,"Enter Your Age",Toast.LENGTH_SHORT);
            errorToast.show();
            Detailsflag=1;
        }



        if(Detailsflag==0)
        {
            Detailsflag=0;
//            @NotNull
//            String uid = database.push().getKey();
//            user user = new user(uid, userid, firstname, lastname, userAge, gender);
//            database.child(uid).setValue(user);
              Toast.makeText(this, "User Added", Toast.LENGTH_LONG).show();
            errorToast.cancel();
        }


    }

    public static void putUser(String left,String right,String ld,String rd){
        String uid = database.push().getKey();
        user user = new user(uid, userid, firstname, lastname, userAge, gender,left,right,ld,rd);
        database.child(uid).setValue(user);
        Log.d("myTag","User added");
        //Toast.makeText(Database.this, "User Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(Database.this,MainActivity.class);
        Database.this.startActivity(mainIntent);
        Database.this.finish();
    }

}