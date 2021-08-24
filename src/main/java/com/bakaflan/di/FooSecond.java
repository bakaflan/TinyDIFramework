package com.bakaflan.di;

import com.bakaflan.di.annotation.Inject;
import com.bakaflan.di.annotation.Singleton;

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

