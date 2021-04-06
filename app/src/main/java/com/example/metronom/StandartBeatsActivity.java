package com.example.metronom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StandartBeatsActivity extends AppCompatActivity {
    private static final int PREVIOUS = 0;
    protected ImageButton metronom_activity;
    protected ImageButton tap_activity;
    protected ImageButton template_activity;
    protected Button buttonTemp2_4;
    protected Button buttonTemp3_4;
    protected Button buttonTemp4_4;
    protected Button buttonTemp50;
    protected Button buttonTemp55;
    protected Button buttonTemp60;
    protected Button buttonTemp65;
    protected Button buttonTemp70;
    protected Button buttonTemp75;
    protected Button buttonTemp80;
    protected Button buttonTemp85;
    protected Button buttonTemp90;
    protected Button buttonTemp95;
    protected Button buttonTemp100;
    protected Button buttonTemp105;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SoundSettings sound = SoundSettings.getInstance(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standart_beats);
                                                                                    //TIME SIGNATURE
        buttonTemp2_4 = (Button) findViewById(R.id.buttonTemp2_4);
        buttonTemp2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(PREVIOUS, 2);
            }
        });

        buttonTemp3_4 = (Button) findViewById(R.id.buttonTemp3_4);
        buttonTemp3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(PREVIOUS, 3);
            }
        });

        buttonTemp4_4 = (Button) findViewById(R.id.buttonTemp4_4);
        buttonTemp4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(PREVIOUS, 4);
            }
        });
                                                                                    //TEMPS
        buttonTemp50 = (Button) findViewById(R.id.buttonTemp50);
        buttonTemp50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(1200, PREVIOUS);
            }
        });

        buttonTemp55 = (Button) findViewById(R.id.buttonTemp55);
        buttonTemp55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(1090, PREVIOUS);
            }
        });

        buttonTemp60 = (Button) findViewById(R.id.buttonTemp60);
        buttonTemp60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(1000, PREVIOUS);
            }
        });

        buttonTemp65 = (Button) findViewById(R.id.buttonTemp65);
        buttonTemp65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(923, PREVIOUS);
            }
        });

        buttonTemp70 = (Button) findViewById(R.id.buttonTemp70);
        buttonTemp70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(857, PREVIOUS);
            }
        });

        buttonTemp75 = (Button) findViewById(R.id.buttonTemp75);
        buttonTemp75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(800, PREVIOUS);
            }
        });

        buttonTemp80 = (Button) findViewById(R.id.buttonTemp80);
        buttonTemp80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(750, PREVIOUS);
            }
        });

        buttonTemp85 = (Button) findViewById(R.id.buttonTemp85);
        buttonTemp85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(705, PREVIOUS);
            }
        });

        buttonTemp90 = (Button) findViewById(R.id.buttonTemp90);
        buttonTemp90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(666, PREVIOUS);
            }
        });

        buttonTemp95 = (Button) findViewById(R.id.buttonTemp95);
        buttonTemp95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(631, PREVIOUS);
            }
        });

        buttonTemp100 = (Button) findViewById(R.id.buttonTemp100);
        buttonTemp100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(600, PREVIOUS);
            }
        });

        buttonTemp105 = (Button) findViewById(R.id.buttonTemp105);
        buttonTemp105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.play(571, PREVIOUS);
            }
        });


                                                                                    //MENU
        metronom_activity = (ImageButton) findViewById(R.id.metronom_activity);
        metronom_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(StandartBeatsActivity.this, MainActivity.class);
                startActivity(new_activity);
            }
        });

        tap_activity = (ImageButton) findViewById(R.id.tap_activity);
        tap_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(StandartBeatsActivity.this, TapActivity.class);
                startActivity(new_activity);
            }
        });

        template_activity = (ImageButton) findViewById(R.id.template_activity);
        template_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(StandartBeatsActivity.this, TemplateActivity.class);
                startActivity(new_activity);
            }
        });
    }
}