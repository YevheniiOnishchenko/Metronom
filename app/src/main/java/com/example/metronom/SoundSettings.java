package com.example.metronom;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public final class SoundSettings {
    private Timer timer = new Timer();
    private MediaPlayer bum;
    private MediaPlayer bum2;
    private static int count=0;

    private static SoundSettings instance;

    private SoundSettings(Context ctx){
        bum = MediaPlayer.create(ctx, R.raw.bum);
        bum2 = MediaPlayer.create(ctx, R.raw.bum2);
    }

    public static SoundSettings getInstance(Context ctx){
        if (null == instance){
            instance = new SoundSettings(ctx);
        }
        return instance;
    }

    public void start(){
        //TODO
    }
    public void stop(){
        //TODO
    }
    public void setTemp(int temp){
        //TODO
    }
    public int getTemp(){
        //TODO
        return 0; //TODO
    }
    public void chooseSound(int time_signature){
        if(count%time_signature == 0){
            bum.start();
        }else {
            bum2.start();
        }
    }

    public void play(int temp, int time_signature){
        if(timer!=null){
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                chooseSound(time_signature);
                count++;
                }
            }, 0, temp);
    }
    public void pause(){
        timer.cancel();
    }


}
