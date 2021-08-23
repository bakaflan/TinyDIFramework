package com.bakaflan.di;

import com.bakaflan.di.annotation.Inject;

public class CircleDependOne {
    private CircleDependSecond circleDependSecond;

    @Inject
    public CircleDependOne(CircleDependSecond circleDependSecond) {
        this.circleDependSecond = circleDependSecond;
    }
}
