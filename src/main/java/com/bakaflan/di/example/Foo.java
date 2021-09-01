package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Inject;

public class Foo {
    private Boo boo;
    private SingletonClass singletonClass;
    private SingletonClass singletonClassTsu;

    @Inject
    public Foo(Boo boo, SingletonClass singletonClass, SingletonClass singletonClassTsu) {
        this.boo = boo;
        this.singletonClass = singletonClass;
        this.singletonClassTsu = singletonClassTsu;
    }

    public Boo getBoo() {
        return boo;
    }

    public SingletonClass getSingletonClass() {
        return singletonClass;
    }

    public boolean isSame(){
        return this.singletonClass.equals(this.singletonClassTsu);
    }
}
