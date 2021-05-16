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

public class StandartBeatsActivity extends AppCompatActivity {
    private static final String TAG = "StandartBeatsActivity";
    protected ImageButton metronom_activity;
    protected ImageButton tap_activity;
    protected ImageButton template_activity;
    SoundSettings sound;
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
        sound = SoundSettings.getInstance(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standart_beats);
                                                                                    //TIME SIGNATURE
        buttonTemp2_4 = (Button) findViewById(R.id.buttonTemp2_4);
        buttonTemp2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTime_signature(2);
                sound.play();
            }
        });

        buttonTemp3_4 = (Button) findViewById(R.id.buttonTemp3_4);
        buttonTemp3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTime_signature(3);
                sound.play();            }
        });

        buttonTemp4_4 = (Button) findViewById(R.id.buttonTemp4_4);
        buttonTemp4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTime_signature(4);
                sound.play();
            }
        });
                                                                                    //TEMPS
        buttonTemp50 = (Button) findViewById(R.id.buttonTemp50);
        buttonTemp50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/50);
                sound.play();
            }
        });

        buttonTemp55 = (Button) findViewById(R.id.buttonTemp55);
        buttonTemp55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/55);
                sound.play();
            }
        });

        buttonTemp60 = (Button) findViewById(R.id.buttonTemp60);
        buttonTemp60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/60);
                sound.play();
            }
        });

        buttonTemp65 = (Button) findViewById(R.id.buttonTemp65);
        buttonTemp65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/65);
                sound.play();
            }
        });

        buttonTemp70 = (Button) findViewById(R.id.buttonTemp70);
        buttonTemp70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/70);
                sound.play();
            }
        });

        buttonTemp75 = (Button) findViewById(R.id.buttonTemp75);
        buttonTemp75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/75);
                sound.play();
            }
        });

        buttonTemp80 = (Button) findViewById(R.id.buttonTemp80);
        buttonTemp80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/80);
                sound.play();
            }
        });

        buttonTemp85 = (Button) findViewById(R.id.buttonTemp85);
        buttonTemp85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/85);
                sound.play();
            }
        });

        buttonTemp90 = (Button) findViewById(R.id.buttonTemp90);
        buttonTemp90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/90);
                sound.play();
            }
        });

        buttonTemp95 = (Button) findViewById(R.id.buttonTemp95);
        buttonTemp95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/95);
                sound.play();
            }
        });

        buttonTemp100 = (Button) findViewById(R.id.buttonTemp100);
        buttonTemp100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/100);
                sound.play();
            }
        });

        buttonTemp105 = (Button) findViewById(R.id.buttonTemp105);
        buttonTemp105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setTemp(60*1000/105);
                sound.play();
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
        Log.d(TAG, "onResume: " + sound);
    }
}