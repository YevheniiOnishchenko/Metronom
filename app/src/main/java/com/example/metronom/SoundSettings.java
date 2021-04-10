package com.example.metronom;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public final class SoundSettings {
    private Timer timer = new Timer();
    private static int count=0;
    private static int temp = 600;
    private static int time_signature = 4;
    private MediaPlayer firstBeat, secondBeat;

    private static SoundSettings instance;
    private Context ctx;

    private SoundSettings(Context ctx){
        firstBeat = MediaPlayer.create(ctx, R.raw.bum);
        secondBeat = MediaPlayer.create(ctx, R.raw.bum3);
        this.ctx = ctx;
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
            firstBeat.start();
        }else {
            secondBeat.start();
        }
    }

    public void setFirstBeat(int firstBeat) {
        switch (firstBeat){
            case 1: this.firstBeat = MediaPlayer.create(ctx, R.raw.bum); break;
            case 2: this.firstBeat = MediaPlayer.create(ctx, R.raw.drum2); break;
            case 3: this.firstBeat = MediaPlayer.create(ctx, R.raw.string1); break;
            case 4: this.firstBeat = MediaPlayer.create(ctx, R.raw.drum1); break;
            case 5: this.firstBeat = MediaPlayer.create(ctx, R.raw.contrab1); break;
            case 6: this.firstBeat = MediaPlayer.create(ctx, R.raw.bass1); break;
            case 7: this.firstBeat = MediaPlayer.create(ctx, R.raw.bass3); break;
            case 8: this.firstBeat = MediaPlayer.create(ctx, R.raw.bass5); break;
        }
    }

    public void setSecondBeat(int secondBeat) {
        switch (secondBeat){
            case 1: this.secondBeat = MediaPlayer.create(ctx, R.raw.bum3); break;
            case 2: this.secondBeat = MediaPlayer.create(ctx, R.raw.drum3); break;
            case 3: this.secondBeat = MediaPlayer.create(ctx, R.raw.string2); break;
            case 4: this.secondBeat = MediaPlayer.create(ctx, R.raw.perkussiya); break;
            case 5: this.secondBeat = MediaPlayer.create(ctx, R.raw.contrab2); break;
            case 6: this.secondBeat = MediaPlayer.create(ctx, R.raw.bass2); break;
            case 7: this.secondBeat = MediaPlayer.create(ctx, R.raw.bass6); break;
            case 8: this.secondBeat = MediaPlayer.create(ctx, R.raw.contrab3); break;
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
        firstBeat.start();
    }

}
