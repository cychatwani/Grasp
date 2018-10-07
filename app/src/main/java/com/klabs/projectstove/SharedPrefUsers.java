package com.klabs.projectstove;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Akshay on 10/7/2018.
 */



public class SharedPrefUsers {

    Context mContext;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;

    private static final String NAME = "Name";
    private static final String PHONE = "Phone";
    private static final String TYPE = "Type";


    public SharedPrefUsers(Context context, String n, String p, int t) {
        mContext = context;
        prefs = mContext.getSharedPreferences(p, 0);
        editor = prefs.edit();

        editor.putString(NAME, n);
        editor.putString(PHONE, p);
        editor.putInt(TYPE, t);

        editor.commit();

    }


}
