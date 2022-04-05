package com.tutorial.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tutorial.graduationproject.ui.main.SplashScreen2Fragment;

public class SplashScreen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen2_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SplashScreen2Fragment.newInstance())
                    .commitNow();
        }
    }
}