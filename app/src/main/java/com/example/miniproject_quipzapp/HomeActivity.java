package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;

public class HomeActivity extends AppCompatActivity {
    private LottieAnimationView quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        quiz = findViewById(R.id.quiz);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        quiz.setVisibility(View.VISIBLE);
        quiz.playAnimation();
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(4000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(HomeActivity.this,PlayActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}