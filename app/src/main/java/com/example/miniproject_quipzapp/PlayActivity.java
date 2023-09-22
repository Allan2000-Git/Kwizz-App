package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    Button playButton;
    ImageButton start;
    TextView txtstart;

    private long backpressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //playButton=findViewById(R.id.playButton);
        start=findViewById(R.id.startQuiz);
        txtstart=findViewById(R.id.txtstart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        txtstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(PlayActivity.this,CategoryActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(backpressed+2000 > System.currentTimeMillis())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Do you want to exit from the app ?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setResult(RESULT_OK, new Intent().putExtra("Exit",true));
                            finish();
                        }
                    }).create().show();
        }
        else
        {
            Toast.makeText(this, "Press again to Exit.", Toast.LENGTH_SHORT).show();
        }

        backpressed=System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Bug","onStop() is called");
        finish();
    }
}