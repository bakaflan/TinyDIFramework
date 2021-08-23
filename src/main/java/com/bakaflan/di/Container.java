package com.bakaflan.di;

import com.bakaflan.di.exception.CreatInstanceErrorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Container {
    private Set<Class<?>> registeredClasses = Collections.synchronizedSet(new HashSet<>());

    public <T> T getInstance(Class<T> clazz){
        Constructor<T> constructor = (Constructor<T>) ClassHelper.pickInjectableConstructor(clazz);
        Object[] params = Arrays.stream(constructor.getParameters()).map(item -> {
            Class<?> temp = item.getType();
            return getInstance(temp);
        }).toArray();
        try {
            return constructor.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new CreatInstanceErrorException(String.format("Create instance error from %s constructor", constructor.getDeclaringClass().getSimpleName()));
        }
    }
}
