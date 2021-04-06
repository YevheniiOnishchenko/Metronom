package com.example.metronom;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public final class SoundSettings {
    private Timer timer = new Timer();
    private MediaPlayer bum, bum2, bum3;
    private static int count=0;
    private static int temp;
    private static int time_signature;

    private static SoundSettings instance;

    private SoundSettings(Context ctx){
        bum = MediaPlayer.create(ctx, R.raw.bum);
        bum2 = MediaPlayer.create(ctx, R.raw.bum2);
        bum3 = MediaPlayer.create(ctx, R.raw.bum3);
    }

    public static SoundSettings getInstance(Context ctx){
        if (null == instance){
            instance = new SoundSettings(ctx);
        }
        return instance;
    }
    public void chooseSound(int time_signature){
        if(count%time_signature == 0){
            bum.start();
        }else {
            bum3.start();
        }
    }

    public void play(int temp, int time_signature){
        if(temp == 0){
            temp = this.temp;
        }

        if(time_signature == 0){
            time_signature = this.time_signature;
        }

        if(timer!=null){
            timer.cancel();
        }
        timer = new Timer();

        int finalTime_signature = time_signature;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                chooseSound(finalTime_signature);
                count++;
                }
            }, 0, temp);

        this.temp = temp;
        this.time_signature = time_signature;
    }
    public void pause(){
        timer.cancel();
    }


}
