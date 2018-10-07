package com.klabs.projectstove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        final EditText phone = findViewById(R.id.student_login_edit);
        Button login = findViewById(R.id.student_login_login);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPrefCurrent curr = new SharedPrefCurrent(getApplication(), phone.getText().toString().trim());
                if(curr.isRegistered()){
                    Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), FrontPageStudent.class));
                }else Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    }
