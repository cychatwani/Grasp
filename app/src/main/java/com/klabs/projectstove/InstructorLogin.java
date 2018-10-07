package com.klabs.projectstove;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InstructorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_login);

        final EditText phone = findViewById(R.id.instructor_login_edit);
        Button login = findViewById(R.id.instructor_login_login);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPrefCurrent curr = new SharedPrefCurrent(getApplication(), phone.getText().toString().trim());
                if(curr.isRegistered()){
                    Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FrontPageInstructor.class);
                    intent.putExtra("phone",phone.getText().toString().trim());
                    startActivity(intent);
                }else Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
