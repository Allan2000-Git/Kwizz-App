package com.example.miniproject_quipzapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WrongDialog
{
    public WrongDialog(Context context)
    {
        this.context = context;
    }

    private Context context;
    private Dialog wrongDialog;
    private TextView textViewCorrectAnswer;

    private MainMenusActivity mainMenusActivity;

    public void wrongDialog(String correctAnswer,final MainMenusActivity mainmenusActivity)
    {
        mainMenusActivity=mainmenusActivity;
        wrongDialog=new Dialog(context);
        wrongDialog.setContentView(R.layout.wrong_dialog);

        Button btnwrongdialog=(Button) wrongDialog.findViewById(R.id.btn_wrong_dialog);

        textViewCorrectAnswer=(TextView) wrongDialog.findViewById(R.id.txt_correct_ans);

        textViewCorrectAnswer.setText("Correct Answer : "+ String.valueOf(correctAnswer));

        btnwrongdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongDialog.dismiss();
                mainMenusActivity.showQuestions();
            }
        });

        wrongDialog.show();
        wrongDialog.setCancelable(false);
        wrongDialog.setCanceledOnTouchOutside(false);

        wrongDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

}

