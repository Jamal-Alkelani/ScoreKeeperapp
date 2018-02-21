package com.example.android.scorekeeperapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class splash_screen extends AppCompatActivity {

    private static int SPLASH_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HomeIntent=new Intent(splash_screen.this,MainActivity.class);
                startActivity(HomeIntent);
                finish();
            }
        },SPLASH_TIME);

    }
}






