package com.klabs.projectstove;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.internal.NavigationMenu;

/**
 * Created by Akshay on 10/7/2018.
 */

public class SharedPrefCourses {
    Context mContext;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;

    private static final String COURSENAME = "course_name";
    private static final String COURSEABV = "course_abv";
    private static final String COURSESTUDENTS = "course_students";
    private static final String COURSEENROLLED = "course_enrolled";
    private static final String COURSELECTURES = "course_lectures";
    private static final String LECTURESTAKEN = "lectures_taken";
    private static final String PROFNAME = "prof_name";
    private static final String PROFABV = "prof_abv";
    private static final String TOTALFEEDBACK = "total_feedback";
    private static final String CURRENTFEEDBACK = "current_feedback";
    private static final String RATING = "rating";
    private static final String HOUR = "hour";
    private static final String DAYS = "days";

    public SharedPrefCourses(Context context, String cname, String cabv, String profname, int tS, int tL, int hour, String d){
        mContext = context;
        prefs = mContext.getSharedPreferences("Course", 0);
        editor = prefs.edit();

        editor.putString(COURSENAME, cname);
        editor.putString(COURSEABV, cabv);
        editor.putString(PROFNAME, profname);
        editor.putInt(COURSELECTURES, tL);
        editor.putInt(COURSESTUDENTS, tS);
        editor.putInt(HOUR, hour);
        editor.putString(DAYS, d);

        editor.commit();
    }

}
