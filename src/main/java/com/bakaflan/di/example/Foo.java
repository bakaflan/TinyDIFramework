package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Inject;

public class Foo {
    private Boo boo;
    private SingletonClass singletonClass;

    @Inject
    public Foo(Boo boo, SingletonClass singletonClass) {
        this.boo = boo;
        this.singletonClass = singletonClass;
    }

    public Boo getBoo() {
        return boo;
    }

    public SingletonClass getSingletonClass() {
        return singletonClass;
    }
}
