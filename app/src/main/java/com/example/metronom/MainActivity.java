package com.example.metronom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private final static int DEFAULT_TEMP = 600;
    private final static int DEFAULT_TIME_SIGNATURE = 4;
    protected ImageButton standart_beats_activity;
    protected ImageButton tap_activity;
    protected ImageButton template_activity;
    protected ImageButton buttonPlay;
    protected ImageButton buttonPause;
    protected SeekBar seekBar;
    protected TextView textViewTemp;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SoundSettings sound = SoundSettings.getInstance(getApplicationContext());

        buttonPlay = (ImageButton)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play();
            }
        });

        buttonPause = (ImageButton)findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
            }
        });

        textViewTemp = (TextView)findViewById(R.id.textViewTemp);
        textViewTemp.setText(String.valueOf(DEFAULT_TEMP));

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int temp = 60*1000/progress;
                sound.setTemp(temp);
                textViewTemp.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sound.play();
            }
        });



        standart_beats_activity = (ImageButton)findViewById(R.id.standart_beats_activity);
        standart_beats_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(MainActivity.this, StandartBeatsActivity.class);
                startActivity(new_activity);
            }
        });

        tap_activity = (ImageButton)findViewById(R.id.tap_activity);
        tap_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(MainActivity.this, TapActivity.class);
                startActivity(new_activity);
            }
        });

        template_activity = (ImageButton)findViewById(R.id.template_activity);
        template_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(MainActivity.this, TemplateActivity.class);
                startActivity(new_activity);
            }
        });

    }





}


