package com.example.metronom;

import androidx.appcompat.app.AppCompatActivity;

public class UI extends AppCompatActivity {

    SoundSettings sound = SoundSettings.getInstance(getApplicationContext());
    public void playAction(){
        sound.play();
    }

    public void pauseAction(){
        sound.pause();
    }

}
