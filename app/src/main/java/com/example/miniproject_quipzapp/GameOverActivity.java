package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    TextView txtTotalScore,txtWrongQues,txtCorrectQues;
    ImageView imgPlayAgain,imgHomeScreen,imgScoreScreen;

    int computersHighScore,historyHighScore,mathsHighScore,englishHighScore,geographyHighScore,currentaffairsHighScore,sportsHighScore,aptitudeHighScore;

    public static final String SCORE_PREFERENCE = "shared_preference";
    public static final String COMPUTERS = "computers_high_score_preference";
    public static final String HISTORY = "history_high_score_preference";
    public static final String MATHS = "maths_high_score_preference";
    public static final String ENGLISH = "english_high_score_preference";
    public static final String GEOGRAPHY = "geography_high_score_preference";
    public static final String CURRENT_AFFAIRS = "ca_high_score_preference";
    public static final String SPORTS = "sports_high_score_preference";
    public static final String APTITUDE = "aptitude_high_score_preference";

    String quizCategory;
    int totalQuestion,wrong,correct,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        txtCorrectQues = findViewById(R.id.txtRightAnsContent);
        txtWrongQues = findViewById(R.id.txtWrongAnsContent);
        txtTotalScore = findViewById(R.id.txtTotalQues);

        imgPlayAgain = findViewById(R.id.img_Replay);
        imgHomeScreen = findViewById(R.id.img_Home);
        imgScoreScreen = findViewById(R.id.img_Score);

        Intent intentContent = getIntent();
        totalQuestion = intentContent.getIntExtra("TotalQuestions",0);
        score = intentContent.getIntExtra("UserScore",0);
        correct = intentContent.getIntExtra("CorrectAnswers",0);
        wrong = intentContent.getIntExtra("WrongAnswers",0);

        txtTotalScore.setText(txtTotalScore.getText() + " " + totalQuestion);
        txtCorrectQues.setText(String.valueOf(correct));
        txtWrongQues.setText(String.valueOf(wrong));

        quizCategory = intentContent.getStringExtra("Category");

        loadHighScore();

        if (quizCategory.equals("Computers"))
        {

            updateComputersHighScores(score);

        }
        else if (quizCategory.equals("History"))
        {

            updateHistoryHighScores(score);

        }
        else if (quizCategory.equals("CurrentAffairs"))
        {

            updateCurrentAffairsHighScores(score);
        }
        else if (quizCategory.equals("Geography"))
        {

            updateGeographyHighScores(score);
        }
        else if (quizCategory.equals("Graphics"))
        {

            updateSportsHighScores(score);
        }
        else if (quizCategory.equals("Aptitude"))
        {

            updateAptitudeHighScores(score);
        }
        else if (quizCategory.equals("Maths"))
        {

            updateMathsHighScores(score);
        }
        else if (quizCategory.equals("English"))
        {

            updateEnglishHighScores(score);
        }

        imgScoreScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(GameOverActivity.this,AllScoresActivity.class);
                startActivity(intent);
                finish();

            }
        });

        imgHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(GameOverActivity.this, PlayActivity.class);
                startActivity(intent);
                finish();

            }
        });

        imgPlayAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(GameOverActivity.this,MainMenusActivity.class);
                intent.putExtra("Category",quizCategory);
                startActivity(intent);
                finish();
            }
        });

    }

    private void updateMathsHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > mathsHighScore)
        {
            mathsHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(MATHS,mathsHighScore);
            editor.apply();

        }
    }

    private void updateHistoryHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > historyHighScore)
        {
            historyHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(HISTORY,historyHighScore);
            editor.apply();

        }
    }

    private void updateComputersHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > computersHighScore)
        {
            computersHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(COMPUTERS,computersHighScore);
            editor.apply();

        }
    }

    private void updateEnglishHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > englishHighScore)
        {
            englishHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(ENGLISH,englishHighScore);
            editor.apply();

        }
    }

    private void updateSportsHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > sportsHighScore)
        {
            sportsHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SPORTS,sportsHighScore);
            editor.apply();

        }
    }

    private void updateGeographyHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > geographyHighScore)
        {
            geographyHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(GEOGRAPHY,geographyHighScore);
            editor.apply();

        }
    }

    private void updateCurrentAffairsHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > currentaffairsHighScore)
        {
            currentaffairsHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(CURRENT_AFFAIRS,currentaffairsHighScore);
            editor.apply();

        }
    }

    private void updateAptitudeHighScores(int scoreToUpdate)
    {
        if(scoreToUpdate > aptitudeHighScore)
        {
            aptitudeHighScore = scoreToUpdate;
            SharedPreferences sharedPreferences = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(APTITUDE,aptitudeHighScore);
            editor.apply();

        }
    }

    private void loadHighScore()
    {
        SharedPreferences sharedPreferencesComputers = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        computersHighScore = sharedPreferencesComputers.getInt(COMPUTERS,0);
        Log.i("Computers Score"," " + computersHighScore);

        SharedPreferences sharedPreferencesHistory = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        historyHighScore = sharedPreferencesHistory.getInt(HISTORY,0);
        Log.i("History Score"," " + historyHighScore);

        SharedPreferences sharedPreferencesMaths = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        mathsHighScore = sharedPreferencesMaths.getInt(MATHS,0);
        Log.i("Mathematics Score"," " + mathsHighScore);

        SharedPreferences sharedPreferencesSports = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        sportsHighScore = sharedPreferencesSports.getInt(SPORTS,0);
        Log.i("Sports Score"," " + sportsHighScore);

        SharedPreferences sharedPreferencesGeography = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        geographyHighScore = sharedPreferencesGeography.getInt(GEOGRAPHY,0);
        Log.i("Geography Score"," " + geographyHighScore);

        SharedPreferences sharedPreferencesCurrentAffairs = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        currentaffairsHighScore = sharedPreferencesCurrentAffairs.getInt(CURRENT_AFFAIRS,0);
        Log.i("Current Affairs Score"," " + currentaffairsHighScore);

        SharedPreferences sharedPreferencesAptitude = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        aptitudeHighScore = sharedPreferencesAptitude.getInt(APTITUDE,0);
        Log.i("Aptitude Score"," " + aptitudeHighScore);

        SharedPreferences sharedPreferencesEnglish = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        englishHighScore = sharedPreferencesEnglish.getInt(ENGLISH,0);
        Log.i("English Score"," " + englishHighScore);
    }

}