package com.example.metronom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    protected ImageButton metronom_activity;
    protected ImageButton standart_beats_activity;
    protected ImageButton tap_activity;
    protected ImageButton template_activity;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metronom_activity = (ImageButton)findViewById(R.id.metronom_activity);
        metronom_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_activity = new Intent(MainActivity.this, MainActivity.class);
                startActivity(new_activity);
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


