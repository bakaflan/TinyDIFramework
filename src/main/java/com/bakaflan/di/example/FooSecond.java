package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Inject;

public class FooSecond {
    private SingletonClass singletonClass;

    @Inject
    public FooSecond(SingletonClass singletonClass) {
        this.singletonClass = singletonClass;
    }

    public SingletonClass getSingletonClass() {
        return singletonClass;
    }
}

