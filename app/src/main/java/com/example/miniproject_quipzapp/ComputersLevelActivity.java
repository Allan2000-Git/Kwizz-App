package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComputersLevelActivity extends AppCompatActivity {
    Button level1,level2,level3,check;
    TextView tv1,tv2,tv3;

    int CL1,CL2,CL3;

    String CatVal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computers_level);

        level1=findViewById(R.id.btnlevel1);
        level2=findViewById(R.id.btnlevel2);
        level3=findViewById(R.id.btnlevel3);
        check=findViewById(R.id.check);

        tv1=findViewById(R.id.tvlevel1);
        tv2=findViewById(R.id.tvlevel1);
        tv3=findViewById(R.id.tvlevel3);

//        level1.setOnClickListener(this);
//        level2.setOnClickListener(this);
//        level3.setOnClickListener(this);

        /*lockUnlockLevels();

        Intent intentCat = getIntent();
        CatVal = intentCat.getStringExtra("Category");
*/
    }
/*
    @Override
    public void onClick(View v)
    {
        if(CatVal.equals("Computers"))
        {
            switch (v.getId())
            {
                case R.id.btnlevel1:

                    Intent intentComputersLevel1 = new Intent(ComputersLevelActivity.this, MainMenusActivity.class);
                    intentComputersLevel1.putExtra("Category",Questions.CATEGORY_COMPUTERS);
                    intentComputersLevel1.putExtra("Level",Questions.LEVEL1);
                    startActivity(intentComputersLevel1);
                    break;

                case R.id.btnlevel2:

                    Intent intentComputersLevel2 = new Intent(ComputersLevelActivity.this, MainMenusActivity.class);
                    intentComputersLevel2.putExtra("Category",Questions.CATEGORY_COMPUTERS);
                    intentComputersLevel2.putExtra("Level",Questions.LEVEL2);
                    startActivity(intentComputersLevel2);
                    break;

                case R.id.btnlevel3:
                    
                    Intent intentComputersLevel3 = new Intent(ComputersLevelActivity.this, MainMenusActivity.class);
                    intentComputersLevel3.putExtra("Category",Questions.CATEGORY_COMPUTERS);
                    intentComputersLevel3.putExtra("Level",Questions.LEVEL3);
                    startActivity(intentComputersLevel3);
                    break;
            }
        }
    }

    public void LoadData(View view)
    {
        tv1.setText(String.valueOf(CL1));
        tv2.setText(String.valueOf(CL2));
        tv3.setText(String.valueOf(CL3));
    }

    private void lockUnlockLevels()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        CL1 = sharedPreferences.getInt(Constant.KEY_COMPUTER_LEVEL_1,0);
        CL2 = sharedPreferences.getInt(Constant.KEY_COMPUTER_LEVEL_2,0);
        CL3 = sharedPreferences.getInt(Constant.KEY_COMPUTER_LEVEL_3,0);

        if(CL1==1)
        {
            level1.setClickable(true);
            level1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_background));
            level1.setOnClickListener(this);
        }
        else if(CL1==0)
        {
            level1.setClickable(false);
            level1.setBackground(ContextCompat.getDrawable(this,R.drawable.locklevel_bg));
        }

        if(CL2==1)
        {
            level2.setClickable(true);
            level2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_background));
            level2.setOnClickListener(this);
        }
        else if(CL2==0)
        {
            level2.setClickable(false);
            level2.setBackground(ContextCompat.getDrawable(this,R.drawable.locklevel_bg));
        }

        if(CL3==1)
        {
            level3.setClickable(true);
            level3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_background));
            level3.setOnClickListener(this);
        }
        else if(CL3==0)
        {
            level3.setClickable(false);
            level3.setBackground(ContextCompat.getDrawable(this,R.drawable.locklevel_bg));
        }

    }*/
}