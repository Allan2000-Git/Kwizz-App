package com.example.miniproject_quipzapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerDialog
{
    public TimerDialog(Context context)
    {
        this.context = context;
    }

    private Context context;
    private Dialog timerDialog;
    private TextView txttimeup;

    //int correctAnswer,int wrongAnswer,int totalsizeQuiz.....parameters below
    public void TimerDialog()
    {
        timerDialog = new Dialog(context);
        timerDialog.setContentView(R.layout.timer_dialog);

        final Button btntimer = (Button) timerDialog.findViewById(R.id.btn_timer);

        //finalScoreCalc(correctAnswer,wrongAnswer,totalsizeQuiz);

        btntimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerDialog.dismiss();
                Intent intent=new Intent(context,MainMenusActivity.class);
                context.startActivity(intent);
            }
        });

        timerDialog.show(); //to show that dialog
        timerDialog.setCancelable(false); //it will not disappear(dialog) until OK is pressed
        timerDialog.setCanceledOnTouchOutside(false); //it will not disappear(dialog) even if we click outside

        timerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

//    private void finalScoreCalc(int correctAnswer, int wrongAnswer, int totalsizeQuiz)
//    {
//        int tempScore;
//        textViewFinalScore=(TextView) finalscoreDialog.findViewById(R.id.txt_final_score);
//
//        if(correctAnswer==totalsizeQuiz)
//        {
//            tempScore=(correctAnswer*20)-(wrongAnswer*5);
//            textViewFinalScore.setText("Final Score : "+ String.valueOf(tempScore));
//        }
//        else if(wrongAnswer==totalsizeQuiz)
//        {
//            tempScore=0;
//            textViewFinalScore.setText("Final Score : "+ String.valueOf(tempScore));
//        }
//        else if(correctAnswer>wrongAnswer)
//        {
//            tempScore=(correctAnswer*20)-(wrongAnswer*5);
//            textViewFinalScore.setText("Final Score : "+ String.valueOf(tempScore));
//        }
//        else if(wrongAnswer>correctAnswer)
//        {
//            tempScore=(correctAnswer*20)-(wrongAnswer*5);
//            textViewFinalScore.setText("Final Score : "+ String.valueOf(tempScore));
//        }
//        else if(correctAnswer==wrongAnswer)
//        {
//            tempScore=(correctAnswer*20)-(wrongAnswer*5);
//            textViewFinalScore.setText("Final Score : "+ String.valueOf(tempScore));
//        }
//    }

}
