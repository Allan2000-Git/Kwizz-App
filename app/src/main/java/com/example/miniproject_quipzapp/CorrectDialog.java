package com.example.miniproject_quipzapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectDialog
{
    public CorrectDialog(Context context)
    {
        this.context = context;
    }

    private Context context;
    private Dialog correctDialog;
    private MainMenusActivity mainMenusActivity;

    public void correctDialog(int score,final MainMenusActivity mainmenusActivity)
    {
        mainMenusActivity=mainmenusActivity;
        correctDialog=new Dialog(context);
        correctDialog.setContentView(R.layout.correct_dialog);

        Button btncorrectdialog = (Button) correctDialog.findViewById(R.id.btn_correct_dialog);
        Score(score);

        btncorrectdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctDialog.dismiss();
                mainMenusActivity.showQuestions();
            }
        });

        correctDialog.show();
        correctDialog.setCancelable(false);
        correctDialog.setCanceledOnTouchOutside(false);

        correctDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void Score(int score)
    {
        TextView txtScore = (TextView) correctDialog.findViewById(R.id.txt_score);
        txtScore.setText("Score : "+ String.valueOf(score));
    }
}
