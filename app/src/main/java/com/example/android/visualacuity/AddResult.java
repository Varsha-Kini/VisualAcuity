package com.example.android.visualacuity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    int flag=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);

        flag=0;
        save = findViewById(R.id.button);
        editText = findViewById(R.id.edittxt_user_id);
        Intent i = getIntent();
        //ArrayList<String> list = Database.list;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=editText.getText().toString();
                for(int j=0;j<Database.list.size();j++)
                {
                    String c=Database.list.get(j);
                    if (id.equals(c)){
                        //Toast.makeText(this,"Entry Exists",Toast.LENGTH_LONG).show();
                        //ENTER CODE FOR ENTRY INTO DB
                        Database.putUser(HomeActivity.s6[1],HomeActivity.s6[0],Double.toString(HomeActivity.power[1]),Double.toString(HomeActivity.power[0]));
                        Toast.makeText(AddResult.this, "User Added", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(AddResult.this,MainActivity.class);
                        AddResult.this.startActivity(i);
                        AddResult.this.finish();
                        HomeActivity.s6[0]=null;
                        HomeActivity.s6[1]=null;
                        HomeActivity.s20[0]=null;
                        HomeActivity.s20[1]=null;
                        HomeActivity.logMAR[0]=1.00;
                        HomeActivity.logMAR[1]=1.00;
                        HomeActivity.power[0]=0;
                        HomeActivity.power[1]=0;
                        HomeActivity.Taketestfirst=1;
                        flag=1;
                        Toast.makeText(AddResult.this, "Data Entered Successful", Toast.LENGTH_LONG).show();
                        Log.d("myTag", "Exist");
                        break;
                    }
                    //Toast.makeText(this,"Enter Does Not Exist",Toast.LENGTH_LONG).show();
                }
                if(flag==0){
                    Log.d("myTag", "Doesnot");
                    Toast.makeText(AddResult.this, "User does not exit, please fill the details.", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(AddResult.this,Database.class);
                    AddResult.this.startActivity(i);
                    AddResult.this.finish();
                }

            }
        });


    }
    @Override
    public void onBackPressed() {
//        Intent mainIntent = new Intent(AddResult.this,MainActivity.class);
//        AddResult.this.startActivity(mainIntent);
//        AddResult.this.finish();
    }
}