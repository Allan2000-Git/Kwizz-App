package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView txthighScore,txtcorrectAnswers,txtwrongAnswers,txttotalQuestions;
    Button playAgain,mainMenu;

    private int highscore;
    public static final String SHARED_PREFERENCE = "shared_preference";
    public static final String SHARED_PREFERENCE_HIGHSCORE = "shared_preference_highscore";

    private long backpressed;

    String categoryVal2 = "";
    // int levelsID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txthighScore=findViewById(R.id.highScore);
        txtcorrectAnswers=findViewById(R.id.correctAnswers);
        txtwrongAnswers=findViewById(R.id.wrongAnswers);
        txttotalQuestions=findViewById(R.id.totalQuestions);
        playAgain=findViewById(R.id.playAgain);
        mainMenu=findViewById(R.id.mainMenu);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,MainMenusActivity.class);
                intent.putExtra("Category",categoryVal2);
                //intent.putExtra("Level",levelsID);
                startActivity(intent);
            }
        });

        loadHighScore();

        //Usage of explicit intent
        Intent intent=getIntent();
        int score = intent.getIntExtra("UserScore",0);
        int totalQuestions = intent.getIntExtra("TotalQuestions",0);
        int correctAnswers = intent.getIntExtra("CorrectAnswers",0);
        int wrongAnswers = intent.getIntExtra("WrongAnswers",0);

        categoryVal2 = intent.getStringExtra("Category"); //sending this data to ResultActivity

        //level changes
        //levelsID = intent.getIntExtra("Level",0);

        txttotalQuestions.setText("Total Questions : " + String.valueOf(totalQuestions));
        txtcorrectAnswers.setText("Correct Answers : " + String.valueOf(correctAnswers));
        txtwrongAnswers.setText("Wrong Answers : " + String.valueOf(wrongAnswers));

        if(score>highscore)
        {
            updateHighScoreValue(score);
        }

    }

    private void updateHighScoreValue(int newhighscore)
    {
        highscore=newhighscore;

        txthighScore.setText("High Score : " + String.valueOf(highscore));

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERENCE_HIGHSCORE,highscore);
        editor.apply();

    }

    private void loadHighScore()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        highscore = sharedPreferences.getInt(SHARED_PREFERENCE_HIGHSCORE,0);
        txthighScore.setText("High Score : " + String.valueOf(highscore));
    }

    @Override
    public void onBackPressed() {
        if(backpressed+2000 > System.currentTimeMillis())
        {
            Intent intent=new Intent(ResultActivity.this,PlayActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press again to Exit.", Toast.LENGTH_SHORT).show();
        }
        backpressed=System.currentTimeMillis();
    }

}