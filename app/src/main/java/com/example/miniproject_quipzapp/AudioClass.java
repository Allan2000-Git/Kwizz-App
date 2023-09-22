package com.example.miniproject_quipzapp;

import android.content.Context;
import android.media.MediaParser;
import android.media.MediaPlayer;

public class AudioClass
{
    private Context context;
    private MediaPlayer mediaPlayer;

    public AudioClass(Context context)
    {
        this.context = context;
    }

    public void setAudio(int flag)
    {
        switch (flag)
        {
            case 1: int correctAudio=R.raw.correctanswer;
                    playAudio(correctAudio);
                    break;
            case 2: int wrongAudio=R.raw.wronganswer;
                    playAudio(wrongAudio);
                    break;
            case 3: int timeAudio=R.raw.timer;
                    playAudio(timeAudio);
                    break;
        }
    }

    private void playAudio(int audioFile)
    {
        mediaPlayer=MediaPlayer.create(context,audioFile);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }
}
