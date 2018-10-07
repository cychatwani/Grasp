package com.klabs.projectstove;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Akshay on 10/7/2018.
 */



public class SharedPrefCurrent {

    Context mContext;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;

    private static final String USER = "user";

    public SharedPrefCurrent(Context con, String p){
        prefs = con.getSharedPreferences(p, 0);
    }

    public boolean isRegistered(){

        String a = prefs.getString("Phone", null);
        Log.i("mytag","phone = "+a);
        if(a == null)   return false;
        else return  true;
    }

    public String profName(){
        String a = prefs.getString("Nsme", null);
        return a;
    }

}
