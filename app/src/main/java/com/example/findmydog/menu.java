package com.example.findmydog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button btnBack;
    private Button btnProfile;
    private Button btnMyActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBack = findViewById(R.id.btnBack);
        btnProfile = findViewById(R.id.btnProfile);
        btnMyActivity = findViewById(R.id.btnMyActivity);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(menu.this, MainActivity.class);
                startActivity(back);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile= new Intent(menu.this, myprofile.class);
                startActivity(profile);
            }
        });

        btnMyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myactivity= new Intent(menu.this, myactivity.class);
                startActivity(myactivity);
            }
        });
    }
}
