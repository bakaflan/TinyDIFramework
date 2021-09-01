package com.bakaflan.di;

public class ClassUtils {
    public static Class<?> getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(String.format("com.bakaflan.di.example.%s", className));
    }
}
