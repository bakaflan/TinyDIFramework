package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Named;

@Named("SonyListener")
public class SonyListener implements Listener{
    public String playMusic(){
        return "Play music using Sony";
    }
}
