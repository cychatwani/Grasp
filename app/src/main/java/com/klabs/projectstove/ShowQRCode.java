package com.klabs.projectstove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowQRCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qrcode);

        Intent intent = getIntent();
        String cabv = intent.getStringExtra("cabv");

        TextView qrText = findViewById(R.id.showqr_text);
        qrText.setText("Scan to enroll for "+cabv);

        Button bButton = findViewById(R.id.showqr_back);
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
