package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AllScoresActivity extends AppCompatActivity {
    TextView txtResultForComputersScore, txtResultForHistoryScore, txtResultForMathsScore,txtResultForEnglishScore,txtResultForSportsScore,
    txtResultForCurrentAffairsScore,txtResultForGeographyScore,txtResultForAptitudeScore;
    ImageView imgHomeScreen;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_scores);

        txtResultForComputersScore =findViewById(R.id.txtResultForComputersS);
        txtResultForHistoryScore =findViewById(R.id.txtResultForHistoryS);
        txtResultForMathsScore =findViewById(R.id.txtResultForMathsS);
        txtResultForEnglishScore =findViewById(R.id.txtResultForEnglishS);
        txtResultForSportsScore =findViewById(R.id.txtResultForSportsS);
        txtResultForCurrentAffairsScore =findViewById(R.id.txtResultForCurrentAffairsS);
        txtResultForGeographyScore =findViewById(R.id.txtResultForGeographyS);
        txtResultForAptitudeScore =findViewById(R.id.txtResultForAptitudeS);
        imgHomeScreen =findViewById(R.id.img_Home);

        loadHighScore();

        imgHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AllScoresActivity.this, PlayActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void loadHighScore()
    {
        SharedPreferences sharedPreferencesComputers = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        computersHighScore = sharedPreferencesComputers.getInt(COMPUTERS,0);
        Log.i("Computers Score"," " + computersHighScore);
        txtResultForComputersScore.setText(" "+computersHighScore);

        SharedPreferences sharedPreferencesHistory = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        historyHighScore = sharedPreferencesHistory.getInt(HISTORY,0);
        Log.i("History Score"," " + historyHighScore);
        txtResultForHistoryScore.setText(" "+historyHighScore);

        SharedPreferences sharedPreferencesMaths = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        mathsHighScore = sharedPreferencesMaths.getInt(MATHS,0);
        Log.i("Mathematics Score"," " + mathsHighScore);
        txtResultForMathsScore.setText(" "+mathsHighScore);

        SharedPreferences sharedPreferencesSports = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        sportsHighScore = sharedPreferencesSports.getInt(SPORTS,0);
        Log.i("Sports Score"," " + sportsHighScore);
        txtResultForSportsScore.setText(" "+sportsHighScore);

        SharedPreferences sharedPreferencesGeography = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        geographyHighScore = sharedPreferencesGeography.getInt(GEOGRAPHY,0);
        Log.i("Geography Score"," " + geographyHighScore);
        txtResultForGeographyScore.setText(" "+geographyHighScore);

        SharedPreferences sharedPreferencesCurrentAffairs = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        currentaffairsHighScore = sharedPreferencesCurrentAffairs.getInt(CURRENT_AFFAIRS,0);
        Log.i("Current Affairs Score"," " + currentaffairsHighScore);
        txtResultForCurrentAffairsScore.setText(" "+currentaffairsHighScore);

        SharedPreferences sharedPreferencesEnglish = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        englishHighScore = sharedPreferencesEnglish.getInt(ENGLISH,0);
        Log.i("English Score"," " + englishHighScore);
        txtResultForEnglishScore.setText(" "+englishHighScore);

        SharedPreferences sharedPreferencesAptitude = getSharedPreferences(SCORE_PREFERENCE,MODE_PRIVATE);
        aptitudeHighScore = sharedPreferencesAptitude.getInt(APTITUDE,0);
        Log.i("Aptitude Score"," " + aptitudeHighScore);
        txtResultForAptitudeScore.setText(" "+aptitudeHighScore);
    }
}