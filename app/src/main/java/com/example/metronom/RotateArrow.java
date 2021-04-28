package com.example.metronom;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.appcompat.app.AppCompatActivity;


public class RotateArrow extends RotateAnimation {

    public RotateArrow(float fromDegrees, float toDegrees, float pivotX, float pivotY) {
        super(fromDegrees, toDegrees, pivotX, pivotY);
    }


    public void setTemp(){
        this.setDuration(getTempSound());
    }

    public int getTempSound(){
        int temp;
        temp = SoundSettings.getTemp();
        return temp;
    }

    public void animationSettings(){
        this.setRepeatMode(Animation.REVERSE);
        this.setRepeatCount(Animation.INFINITE);
        this.setInterpolator(new LinearInterpolator());
    }

}
