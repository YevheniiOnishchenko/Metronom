package com.example.metronom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TemplateActivity extends AppCompatActivity {
    protected ImageButton metronom_activity;
    protected ImageButton standart_beats_activity;
    protected ImageButton tap_activity;
    private Button buttonStandart;
    private Button buttonDrums;
    private Button buttonStrings;
    private Button buttonPercussion;
    private Button buttonContrabass;
    private Button buttonBass;
    private Button buttonBass2;
    private Button buttonUniversal;
    private SoundSettings sound = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template);

        sound =  SoundSettings.getInstance(getApplicationContext());
        buttonStandart = (Button)findViewById(R.id.buttonStandart);
        buttonStandart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(1);
                sound.setSecondBeat(1);
                sound.play();

            }
        });

        buttonDrums = (Button)findViewById(R.id.buttonDrums);
        buttonDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(2);
                sound.setSecondBeat(2);
                sound.play();
            }
        });

        buttonStrings = (Button)findViewById(R.id.buttonStrings);
        buttonStrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(3);
                sound.setSecondBeat(3);
                sound.play();
            }
        });

        buttonPercussion = (Button)findViewById(R.id.buttonPercussion);
        buttonPercussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(4);
                sound.setSecondBeat(4);
                sound.play();
            }
        });

        buttonContrabass = (Button)findViewById(R.id.buttonContrabass);
        buttonContrabass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(5);
                sound.setSecondBeat(5);
                sound.play();
            }
        });

        buttonBass = (Button)findViewById(R.id.buttonBass);
        buttonBass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(6);
                sound.setSecondBeat(6);
                sound.play();
            }
        });

        buttonBass2 = (Button)findViewById(R.id.buttonBass2);
        buttonBass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(7);
                sound.setSecondBeat(7);
                sound.play();
            }
        });

        buttonUniversal = (Button)findViewById(R.id.buttonUniversal);
        buttonUniversal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setFirstBeat(8);
                sound.setSecondBeat(8);
                sound.play();
            }
        });

        metronom_activity = (ImageButton)findViewById(R.id.metronom_activity);
        metronom_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TemplateActivity.this, MainActivity.class);
                startActivity(new_activity);
            }
        });

        standart_beats_activity = (ImageButton)findViewById(R.id.standart_beats_activity);
        standart_beats_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TemplateActivity.this, StandartBeatsActivity.class);
                startActivity(new_activity);
            }
        });

        tap_activity = (ImageButton)findViewById(R.id.tap_activity);
        tap_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(TemplateActivity.this, TapActivity.class);
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