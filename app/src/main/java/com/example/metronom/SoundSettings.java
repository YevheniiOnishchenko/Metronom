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
    private static int temp = 600;
    private static int time_signature = 4;

    private static SoundSettings instance;

    private SoundSettings(Context ctx){
        bum = MediaPlayer.create(ctx, R.raw.bum);
        bum3 = MediaPlayer.create(ctx, R.raw.bum3);
    }

    public void setTemp(int temp){
        this.temp = temp;
    }

    public static void setTime_signature(int time_signature) {
        SoundSettings.time_signature = time_signature;
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

    public void play(){

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

    public void playSound(){
        bum.start();
    }

}
