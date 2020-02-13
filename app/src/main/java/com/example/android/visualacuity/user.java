package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

public class user {
    String uid;
    String userid;
    String firstname;
    String lastname;
    String userage;
    String gender;





    public user(){

    }

    public user(String uid, String userid, String firstname, String lastname, String userage, String gender) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname=lastname;
        this.userage = userage;
        this .uid=uid;
        this.gender = gender;

    }


    public String getUid(){
        return uid;
    }

    public String getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUserage() {
        return userage;
    }

    public String getGender() {
        return gender;
    }
}


