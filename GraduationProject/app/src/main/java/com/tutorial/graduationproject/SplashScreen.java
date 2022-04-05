package com.tutorial.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    View bgView;
    ImageView logoImageView;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bgView = findViewById(R.id.bigsplashscreen_view);
        logoImageView = findViewById(R.id.splashscreen_logo_imageview);
        lottieAnimationView = findViewById(R.id.splashscreen_smile_lottieAnim);


        bgView.animate().translationY(-3000).setDuration(2000).setStartDelay(5500);
        logoImageView.animate().translationY(2000).setDuration(2000).setStartDelay(5500);
        lottieAnimationView.animate().translationY(2000).setDuration(2000).setStartDelay(5500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        }, 7500);




    }
}