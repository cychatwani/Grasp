package com.klabs.projectstove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
    private int type = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText name = findViewById(R.id.login_register_name);
        final EditText phone = findViewById(R.id.login_register_phone);

        Button register = findViewById(R.id.login_register_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().length() != 0
                        && phone.getText().toString().trim().length() !=0
                        && type!=0){
                    //TODO Store - DONE
                    SharedPrefUsers USERS = new SharedPrefUsers(getApplicationContext(),
                            name.getText().toString().trim(), phone.getText().toString().trim(),
                            type);
                    startActivity(new Intent(getApplicationContext(), loginMainActivity.class));
                    finish();
                }
            }
        });


    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.login_register_instructor:
                if (checked)
                    type = 1;
                    break;
            case R.id.login_register_student:
                if (checked)
                    type = 2;
                    break;
        }
    }

}
