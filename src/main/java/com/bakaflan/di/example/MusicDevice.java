package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Inject;
import com.bakaflan.di.annotation.Named;

public class MusicDevice {
    private Listener listener;

    @Inject
    public MusicDevice(@Named("SonyListener")Listener listener) {
        this.listener = listener;
    }

    public String playMusic(){
        return listener.playMusic();
    }
}
