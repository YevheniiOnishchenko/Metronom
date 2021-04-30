package com.example.metronom;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class RotateArrow {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public RotateArrow(View animateTarget, float fromDegrees, float toDegrees) {
        animator = ObjectAnimator.ofFloat(animateTarget, "rotation",
                fromDegrees, toDegrees);

        animator.setDuration(getTempSound());
        animator.setRepeatCount(animator.INFINITE);
        animator.setRepeatMode(animator.REVERSE);

        setTemp();

        animator.start();
        pause();
    }


    public void setTemp(){
        animator.setDuration(getTempSound());
    }

    public int getTempSound(){
        int temp;
        temp = SoundSettings.getTemp();
        return temp;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void pause() {
        animator.pause();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resume() {
        animator.resume();
    }

    private ObjectAnimator animator;
}
