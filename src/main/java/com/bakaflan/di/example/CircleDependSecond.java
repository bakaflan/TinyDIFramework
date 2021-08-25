package com.bakaflan.di.example;

import com.bakaflan.di.annotation.Inject;

public class CircleDependSecond {
    private CircleDependOne circleDependOne;

    @Inject
    public CircleDependSecond(CircleDependOne circleDependOne) {
        this.circleDependOne = circleDependOne;
    }
}
