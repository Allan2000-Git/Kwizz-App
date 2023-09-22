package com.example.miniproject_quipzapp;

import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class MainMenusActivity extends AppCompatActivity {

    private RadioGroup rdgrp;
    private RadioButton rb1,rb2,rb3,rb4;
    private Button confirmnext;
    private TextView qcount,score,correct,wrong,textViewQuestion ,timecount;
    private int questionCounter;
    private int questionTotalCount;
    private Questions currentQuestions;
    private boolean answered;
    private ArrayList<Questions> questionsList;

    private Handler handler = new Handler();

    private ColorStateList btnLabelColor;

    private int correctAnswer=0, wrongAnswer=0;

    private TimerDialog timerDialog;
    private CorrectDialog correctDialog;
    private WrongDialog wrongDialog;
    private AudioClass audioClass;

    private int totalSizeQuiz=0;
    int myscore=0;
    int FLAG=0;

    private static final long COUNTDOWN_MS=15000;
    private CountDownTimer countDownTimer;
    private long timeLeftMs;

    private long backpressed;

    private String categoryVal="";
    //private int levelsID=0;
    //int CL2_UNLOCK=0, CL3_UNLOCK=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menus);

        rdgrp=findViewById(R.id.rdgrp);
        rb1=findViewById(R.id.rdbtn1);
        rb2=findViewById(R.id.rdbtn2);
        rb3=findViewById(R.id.rdbtn3);
        rb4=findViewById(R.id.rdbtn4);
        confirmnext=findViewById(R.id.confirmnext);
        qcount=findViewById(R.id.totalQuestions);
        score=findViewById(R.id.totalScore);
        correct=findViewById(R.id.correctAnswers);
        wrong=findViewById(R.id.wrongAnswers);
        textViewQuestion =findViewById(R.id.txtQuestionContainer);
        timecount=findViewById(R.id.timeAnswers);

        Intent categorylevelintent = getIntent();
        categoryVal = categorylevelintent.getStringExtra("Category");
        //levelsID = categorylevelintent.getIntExtra("Level",0);  //level changes

        fetchDB();

        btnLabelColor=rb1.getTextColors();

        timerDialog=new TimerDialog(this);
        correctDialog=new CorrectDialog(this);
        wrongDialog=new WrongDialog(this);
        audioClass=new AudioClass(this);

    }

    private void fetchDB()
    {
        QuizDbHelper qDB = new QuizDbHelper(this);
        //level changes
        questionsList =qDB.getAllQuestionsCategory(categoryVal); //calling the method with category
        startQuiz();
    }

    private void startQuiz()
    {
        questionTotalCount = questionsList.size();
        Collections.shuffle(questionsList);
        showQuestions();

        //onClick for a radio button within radio group
        rdgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rdbtn1:
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        break;

                    case R.id.rdbtn2:
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_selected));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        break;

                    case R.id.rdbtn3:
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        break;

                    case R.id.rdbtn4:
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
                        break;
                }
            }
        });

        confirmnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered)
                {
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()||rb4.isChecked())
                    {
                        quizOperations();
                    }
                    else
                    {
                        Toasty.info(MainMenusActivity.this, "Please select an option", Toast.LENGTH_SHORT, true).show();
                    }
                }
            }
        });
    }

    //if any one of the options is selected then...
    private void quizOperations()
    {
        answered=true;

        countDownTimer.cancel();

        //stores the id of radio button checked...that is button in which the option is selected
        RadioButton rbSelected =findViewById(rdgrp.getCheckedRadioButtonId());
        //stores the option number to answerNum variable...+1 is needed because it gives unwanted answers while checking for correct answers.
        int answerNum = rdgrp.indexOfChild(rbSelected)+1;

        checkSolutions(answerNum,rbSelected);
    }

    public void showQuestions()
    {
        rdgrp.clearCheck(); //clear the checked button for each question

        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));
        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.optback));

        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);

        //checks if current question number is less than total questions given
        if(questionCounter<questionTotalCount)
        {
            currentQuestions = questionsList.get(questionCounter);
            textViewQuestion.setText(currentQuestions.getQuestion());
            rb1.setText(currentQuestions.getOption1());
            rb2.setText(currentQuestions.getOption2());
            rb3.setText(currentQuestions.getOption3());
            rb4.setText(currentQuestions.getOption4());

            questionCounter++;
            answered=false;

            confirmnext.setText("CONFIRM");

            qcount.setText("Questions : "+questionCounter+" / "+questionTotalCount);

            timeLeftMs=COUNTDOWN_MS;
            startCountDown();
        }
        //if it has reached total count or greater than that
        else
        {
            //Toast.makeText(this, "Quiz Completed !!", Toast.LENGTH_SHORT).show();

            Toasty.success(this, "Successfully completed the Kwizz !!!", Toast.LENGTH_SHORT, true).show();

            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);
            rb4.setClickable(false);
            confirmnext.setClickable(false);

            //totalSizeQuiz=questionsList.size();
            handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    //finalScoreDialog.finalScoreDialog(correctAnswer,wrongAnswer,totalSizeQuiz);
                    //result activity
                    finalResult();
                }
            },2000);
        }
    }

    //quiz logic starts here
    private void checkSolutions(int answerNum, RadioButton rbSelected)
    {
        switch (currentQuestions.getAnswerNum())
        {
            //to check if selected radio button value equals to that of the original value provided(answer)...perform for each button
            case 1 : if(currentQuestions.getAnswerNum() == answerNum)
            {
                rb1.setBackground(ContextCompat.getDrawable(this,R.drawable.answer_correct));
                rb1.setTextColor(Color.WHITE);

                //if answer is correct,then update the correct textview
                correctAnswer++;
                correct.setText("Correct : "+String.valueOf(correctAnswer));

                myscore+=10;
                score.setText("Score : "+ String.valueOf(myscore));
                correctDialog.correctDialog(myscore,this);

                FLAG=1;
                audioClass.setAudio(FLAG);

            }
            else
            {
                changetoWrongColor(rbSelected);

                //if answer is wrong,then update the wrong textview
                wrongAnswer++;
                wrong.setText("Wrong : "+String.valueOf(wrongAnswer));

                String correctAnswer=(String) rb1.getText();
                wrongDialog.wrongDialog(correctAnswer,this);

                FLAG=2;
                audioClass.setAudio(FLAG);

            }
                break;
            case 2 : if(currentQuestions.getAnswerNum() == answerNum)
            {
                rb2.setBackground(ContextCompat.getDrawable(this,R.drawable.answer_correct));
                rb2.setTextColor(Color.WHITE);

                correctAnswer++;
                correct.setText("Correct : "+String.valueOf(correctAnswer));

                myscore+=10;
                score.setText("Score : "+ String.valueOf(myscore));
                correctDialog.correctDialog(myscore,this);

                FLAG=1;
                audioClass.setAudio(FLAG);

            }
            else
            {
                changetoWrongColor(rbSelected);

                wrongAnswer++;
                wrong.setText("Wrong : "+String.valueOf(wrongAnswer));

                String correctAnswer=(String) rb2.getText();
                wrongDialog.wrongDialog(correctAnswer,this);

                FLAG=2;
                audioClass.setAudio(FLAG);

            }
                break;
            case 3 : if(currentQuestions.getAnswerNum() == answerNum)
            {
                rb3.setBackground(ContextCompat.getDrawable(this,R.drawable.answer_correct));
                rb3.setTextColor(Color.WHITE);

                correctAnswer++;
                correct.setText("Correct : "+String.valueOf(correctAnswer));

                myscore+=10;
                score.setText("Score : "+ String.valueOf(myscore));
                correctDialog.correctDialog(myscore,this);

                FLAG=1;
                audioClass.setAudio(FLAG);

            }
            else
            {
                changetoWrongColor(rbSelected);

                wrongAnswer++;
                wrong.setText("Wrong : "+String.valueOf(wrongAnswer));

                String correctAnswer=(String) rb3.getText();
                wrongDialog.wrongDialog(correctAnswer,this);

                FLAG=2;
                audioClass.setAudio(FLAG);

            }
                break;
            case 4 : if(currentQuestions.getAnswerNum() == answerNum)
            {
                rb4.setBackground(ContextCompat.getDrawable(this,R.drawable.answer_correct));
                rb4.setTextColor(Color.WHITE);

                correctAnswer++;
                correct.setText("Correct : "+String.valueOf(correctAnswer));

                myscore+=10;
                score.setText("Score : "+ String.valueOf(myscore));
                correctDialog.correctDialog(myscore,this);

                FLAG=1;
                audioClass.setAudio(FLAG);

            }
            else
            {
                changetoWrongColor(rbSelected);

                wrongAnswer++;
                wrong.setText("Wrong : "+String.valueOf(wrongAnswer));

                String correctAnswer=(String) rb4.getText();
                wrongDialog.wrongDialog(correctAnswer,this);

                FLAG=2;
                audioClass.setAudio(FLAG);

            }
                break;
        }
        if(questionCounter==questionTotalCount)
        {
            confirmnext.setText("CONFIRM AND FINISH");
        }
    }

    void changetoWrongColor(RadioButton rbSelected)
    {
        rbSelected.setBackground(ContextCompat.getDrawable(this,R.drawable.answer_wrong));
        rbSelected.setTextColor(Color.WHITE);
    }

    private void startCountDown()
    {
        countDownTimer=new CountDownTimer(timeLeftMs,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMs=millisUntilFinished;
                timerCountDown();
            }

            @Override
            public void onFinish() {
                timeLeftMs=0;
                timerCountDown();
            }
        }.start();
    }

    //timer function...
    private void timerCountDown()
    {
        int minutes=(int) (timeLeftMs/1000) / 60;
        int seconds=(int) (timeLeftMs/1000) % 60;

        //convert time to string to display
        String timeText=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timecount.setText(timeText);

        if(timeLeftMs<5000)
        {
            timecount.setTextColor(Color.RED);
            FLAG=3;
            audioClass.setAudio(FLAG);
        }
        else
        {
            timecount.setTextColor(btnLabelColor);
        }

        if(timeLeftMs==0)
        {
            //Toast.makeText(this, "Time is up !!!", Toast.LENGTH_SHORT).show();
            Toasty.error(MainMenusActivity.this,"Oops !! Time is up !!",Toasty.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    timerDialog.TimerDialog();
                }
            },2000);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Bug","onRestart() is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Bug","onStop() is called");
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Bug","onPause() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(countDownTimer!=null)
        {
            countDownTimer.cancel();
        }
    }

    private void finalResult()
    {
        //unlockLevels();

        //Usage of explicit intent
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent result=new Intent(MainMenusActivity.this,GameOverActivity.class);
                result.putExtra("UserScore",myscore);
                result.putExtra("TotalQuestions",questionTotalCount);
                result.putExtra("CorrectAnswers",correctAnswer);
                result.putExtra("WrongAnswers",wrongAnswer);

                result.putExtra("Category",categoryVal); //getting data from CategoryActivity

                //result.putExtra("Level",levelsID);  //level changes

                startActivity(result);
            }
        },1000);
    }

    @Override
    public void onBackPressed() {
        if(backpressed+2000 > System.currentTimeMillis())
        {
            Intent intent=new Intent(MainMenusActivity.this,PlayActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press again to Exit.", Toast.LENGTH_SHORT).show();
        }
        backpressed=System.currentTimeMillis();
    }

    //level changes
    /*private void unlockLevels()
    {
        unlockComputersLevels();
    }

    private void unlockComputersLevels()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        if(levelsID==1 && categoryVal.equals("Computers"))
        {
            CL2_UNLOCK = correctAnswer;

            // if(sharedPreferences.getInt(Constant.KEY_COMPUTER_LEVEL_1,0)==1)

                if(CL2_UNLOCK >=2 ) //checks if computers level have answered 2 or more than 2 then we unlock level 3
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constant.KEY_COMPUTER_LEVEL_2,1);
                editor.apply();

                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constant.KEY_CAT_COMPUTER_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }
        else if(levelsID==2 && categoryVal.equals("Computers"))
        {
            CL3_UNLOCK = correctAnswer;

            if(sharedPreferences.getInt(Constant.KEY_COMPUTER_LEVEL_2,0)==1) {

                if (CL3_UNLOCK >= 2) //checks if computers level have answered 2 or more than 2 then we unlock level 3
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Constant.KEY_COMPUTER_LEVEL_3, 1);
                    editor.apply();

                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor1.putString(Constant.KEY_CAT_COMPUTER_LEVEL_3, "Unlock");
                    editor1.apply();
                }
            }
        }
    }*/
}