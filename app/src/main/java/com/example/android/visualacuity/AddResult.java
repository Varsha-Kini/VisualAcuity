package com.example.android.visualacuity;

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
                        flag=1;
                        Log.d("myTag", "Exist");
                        break;
                    }
                    //Toast.makeText(this,"Enter Does Not Exist",Toast.LENGTH_LONG).show();
                }
                if(flag==0){
                    Log.d("myTag", "Doesnot");
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
