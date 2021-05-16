package com.example.metronom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class TapActivity extends AppCompatActivity {
    protected ImageButton metronom_activity;
    protected ImageButton standart_beats_activity;
    protected ImageButton template_activity;
    SoundSettings sound;
    protected Button buttonTap;
    protected TextView textViewLast;
    protected TextView textViewAvarage;
    protected Button buttonLast;
    protected Button buttonAvarage;
    private long tempLast=0;
    private long tempAvarage=0;
    private int countOfTaps=0;
    private Date prevTime = new Date();
    private Date currTime = new Date();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap);
        sound = SoundSettings.getInstance(getApplicationContext());

        textViewLast = (TextView)findViewById(R.id.textViewLast);
        textViewAvarage = (TextView)findViewById(R.id.textViewAvarage);

        buttonTap = (Button) findViewById(R.id.buttonTap);
        buttonTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();

                if(countOfTaps>0) {
                    prevTime = currTime;
                    currTime = new Date();
                    sound.playSound();
                    tempLast = currTime.getTime() - prevTime.getTime();

                    tempAvarage += 60*1000/tempLast;

                    textViewLast.setText(String.valueOf(60*1000/tempLast));
                    textViewAvarage.setText(String.valueOf(tempAvarage/countOfTaps));
                    countOfTaps++;

                }else {
                    textViewLast.setText(String.valueOf(0));
                    textViewAvarage.setText(String.valueOf(0));
                    currTime = new Date();
                    countOfTaps++;

                }

                if(tempLast>3000){
                    countOfTaps=1;
                    tempAvarage=0;
                    tempLast=0;
                    textViewLast.setText(String.valueOf(0));
                    textViewAvarage.setText(String.valueOf(0));
                }
            }
        });

        buttonLast = (Button) findViewById(R.id.buttonLast);
        buttonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/Integer.parseInt(textViewLast.getText().toString()));
                sound.play();
            }
        });

        buttonAvarage = (Button) findViewById(R.id.buttonAvarage);
        buttonAvarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/Integer.parseInt(textViewAvarage.getText().toString()));
                sound.play();
            }
        });

        metronom_activity = (ImageButton)findViewById(R.id.metronom_activity);
        metronom_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TapActivity.this, MainActivity.class);
                startActivity(new_activity);
            }
        });

        standart_beats_activity = (ImageButton)findViewById(R.id.standart_beats_activity);
        standart_beats_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TapActivity.this, StandartBeatsActivity.class);
                startActivity(new_activity);
            }
        });

        template_activity = (ImageButton)findViewById(R.id.template_activity);
        template_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TapActivity.this, TemplateActivity.class);
                startActivity(new_activity);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onStop(){
        super.onStop();
        sound.pauseWithoutStateChange();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        sound.playByStateValue();
    }
}