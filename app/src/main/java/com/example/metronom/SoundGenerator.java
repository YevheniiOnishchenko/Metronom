package com.example.metronom;

import android.app.Application;
import android.util.Log;

public class SoundGenerator extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("MY", "onCreate MyApp");
    }
}
