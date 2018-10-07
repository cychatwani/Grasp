package com.klabs.projectstove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class loginMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ImageButton instructorImageButton=(ImageButton)findViewById(R.id.instructorImageBtn);
        ImageButton studentImageButton=(ImageButton)findViewById(R.id.studentImageButton);
        instructorImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MYTAG","Instructor..");
            }
        });
        studentImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FrontPageStudent.class));
            }
        });
        instructorImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FrontPageInstructor.class));
            }
        });
    }
}
