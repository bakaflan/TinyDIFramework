package com.bakaflan.di;

import com.bakaflan.di.annotation.Inject;

public class Foo {
    private Boo boo;

    @Inject
    public Foo(Boo a) {
        this.boo = a;
    }

    public Boo getBoo() {
        return boo;
    }
}
