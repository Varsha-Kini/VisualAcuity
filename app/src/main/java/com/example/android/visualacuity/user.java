package com.example.android.visualacuity;

import androidx.appcompat.app.AppCompatActivity;

public class user {
    String uid;
    String userid;
    String firstname;
    String lastname;
    String userage;
    String gender;
    String left;
    String right;
    String ld;
    String rd;





    public user(){


    }

    public user(String uid, String userid, String firstname, String lastname, String userage, String gender, String left, String right,String ld,String rd) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname=lastname;
        this.userage = userage;
        this.uid=uid;
        this.gender = gender;
        this.left=left;
        this.right=right;
        this.ld=ld;
        this.rd=rd;

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

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getLd() {
        return ld;
    }

    public String getRd() {
        return rd;
    }


}


