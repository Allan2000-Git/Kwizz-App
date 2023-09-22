package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    Button history,computers,maths,english,sports,aptitude,currentaffairs,geography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        history=findViewById(R.id.history);
        computers=findViewById(R.id.computers);
        maths=findViewById(R.id.maths);
        english=findViewById(R.id.english);
        sports=findViewById(R.id.sports);
        aptitude=findViewById(R.id.aptitude);
        currentaffairs=findViewById(R.id.currentaffairs);
        geography=findViewById(R.id.geography);

        history.setOnClickListener(this);
        computers.setOnClickListener(this);
        maths.setOnClickListener(this);
        english.setOnClickListener(this);
        sports.setOnClickListener(this);
        currentaffairs.setOnClickListener(this);
        geography.setOnClickListener(this);
        aptitude.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.history :
                Intent historyintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                historyintent.putExtra("Category",Constants.HISTORY);
                startActivity(historyintent);
                break;

            case R.id.computers :
                //createLevelsComputers();
                Intent computersintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                computersintent.putExtra("Category",Constants.COMPUTERS);
                startActivity(computersintent);
                break;

            case R.id.maths :
                Intent mathsintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                mathsintent.putExtra("Category",Constants.MATHS);
                startActivity(mathsintent);
                break;

            case R.id.english :
                Intent englishintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                englishintent.putExtra("Category",Constants.ENGLISH);
                startActivity(englishintent);
                break;

            case R.id.sports :
                Intent sportsintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                sportsintent.putExtra("Category",Constants.SPORTS);
                startActivity(sportsintent);
                break;

            case R.id.aptitude :
                Intent aptitudeintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                aptitudeintent.putExtra("Category",Constants.APTITUDE);
                startActivity(aptitudeintent);
                break;

            case R.id.currentaffairs :
                Intent currentaffairsintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                currentaffairsintent.putExtra("Category",Constants.CURRENTAFFAIRS);
                startActivity(currentaffairsintent);
                break;

            case R.id.geography :
                Intent geographyintent = new Intent(CategoryActivity.this, MainMenusActivity.class);
                geographyintent.putExtra("Category",Constants.GEOGRAPHY);
                startActivity(geographyintent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity.this, PlayActivity.class);
        startActivity(intent);
        finish();
    }

    //level changes
   /* private void createLevelsComputers()
    {
        //Package level shared preference
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 1 -----> unlocked      0 -----> locked    By default first level is unlocked
        editor.putInt(Constant.KEY_COMPUTER_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_COMPUTER_LEVEL_1,"Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_COMPUTER_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_1,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_2,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_COMPUTER_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_1,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_2,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_COMPUTER_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_1,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_2,1);
            editor.putInt(Constant.KEY_COMPUTER_LEVEL_3,1);
        }
    }*/
}