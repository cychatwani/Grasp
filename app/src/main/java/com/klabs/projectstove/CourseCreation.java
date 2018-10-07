package com.klabs.projectstove;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class CourseCreation extends AppCompatActivity {

    int daysofweek[] = new int[7];
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_creation);

        phone = getIntent().getStringExtra("phone");

        final int timeHour;

        final EditText course_creation_name=(EditText)findViewById(R.id.course_creation_name);

        final EditText course_creation_abv=(EditText)findViewById(R.id.course_creation_abv);

        final EditText course_creation_students=(EditText)findViewById(R.id.course_creation_students);

        final EditText course_creation_lectures=(EditText)findViewById(R.id.course_creation_lectures);

        Button course_creation_monday=(Button)findViewById(R.id.course_creation_monday);

        Button course_creation_tuesday=(Button)findViewById(R.id.course_creation_tuesday);

        Button course_creation_wednesday=(Button)findViewById(R.id.course_creation_wednesday);

        Button course_creation_thursday=(Button)findViewById(R.id.course_creation_thursday);

        Button course_creation_friday=(Button)findViewById(R.id.course_creation_friday);

        Button course_creation_saturday=(Button)findViewById(R.id.course_creation_saturday);

        Button course_creation_sunday=(Button)findViewById(R.id.course_creation_sunday);

        TimePicker course_creation_time=(TimePicker)findViewById(R.id.course_creation_time);

        Button course_creation_add=(Button)findViewById(R.id.course_creation_add);

        course_creation_monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[0]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[0] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[0] = 1;
                }
            }
        });
        course_creation_tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[1]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[1] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[1] = 1;
                }
            }
        });
        course_creation_wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[2]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[2] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[2] = 1;
                }
            }
        });
        course_creation_thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[3]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[3] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[3] = 1;
                }
            }
        });
        course_creation_friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[4]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[4] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[4] = 1;
                }
            }
        });
        course_creation_saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[5]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[5] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[5] = 1;
                }
            }
        });
        course_creation_sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daysofweek[6]!=1) {
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[6] = 1;
                }else{
                    v.setBackgroundColor(Color.parseColor("#FFB74D"));
                    daysofweek[6] = 1;
                }
            }
        });

        timeHour = course_creation_time.getHour();


        course_creation_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(course_creation_name.getText().toString().trim().length()!=0
                        && course_creation_abv.getText().toString().trim().length()!=0
                        && course_creation_students.getText().toString().length()!=0
                        && course_creation_lectures.getText().toString().length()!=0
                        ){
                        //TODO: Store the data - DONE
                        SharedPrefCourses pref = new SharedPrefCourses(getApplicationContext(),
                                course_creation_name.getText().toString().trim(),
                                course_creation_abv.getText().toString().trim(),
                                profName(), Integer.parseInt(course_creation_students.getText().toString().trim()),
                                Integer.parseInt(course_creation_lectures.getText().toString().trim()),
                                timeHour,
                                getDays());
                         finish();
                }
            }
        });


    }

    public String profName(){
        SharedPrefCurrent curr = new SharedPrefCurrent(getApplicationContext(), phone);
        return curr.profName();
    }

    public String getDays(){
        String weekDay[]={"M","Tu","W","Th","F","Sa","Su"};
        String  result="";

        for(int i=0;i<7;i++)
        {
            if(daysofweek[i]==1)
                result=result+weekDay[i]+" ";
        }
        return result;
    }

}
