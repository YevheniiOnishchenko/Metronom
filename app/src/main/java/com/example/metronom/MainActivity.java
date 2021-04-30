package com.example.metronom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private final static int DEFAULT_TEMP = 600;
    protected ImageButton standart_beats_activity;
    protected ImageButton tap_activity;
    protected ImageButton template_activity;
    protected ImageButton buttonPlay;
    protected ImageButton buttonPause;
    protected SeekBar seekBar;
    protected TextView textViewTemp;
    protected ImageView imageViewArrow;
    SoundSettings sound;
    RotateArrow animation;
    UI ui;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = SoundSettings.getInstance(getApplicationContext());

        imageViewArrow = (ImageView)findViewById(R.id.imageViewArrow);
        animation = new RotateArrow(imageViewArrow,-40, 40);

        buttonPlay = (ImageButton)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play();
                animation.resume();
            }
        });

        buttonPause = (ImageButton)findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
                animation.pause();
            }
        });

        textViewTemp = (TextView)findViewById(R.id.textViewTemp);
        textViewTemp.setText(String.valueOf(60*1000/DEFAULT_TEMP));

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int temp = 60*1000/progress;
                sound.setTemp(temp);
                textViewTemp.setText(String.valueOf(progress));
                animation.setTemp();
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


