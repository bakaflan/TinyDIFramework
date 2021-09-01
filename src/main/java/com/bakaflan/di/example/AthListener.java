package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Named;

@Named("AthListener")
public class AthListener implements Listener{
    public String playMusic(){
        return "Play music using ATH";
    }
}
