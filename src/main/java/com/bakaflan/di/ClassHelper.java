package com.bakaflan.di;

import com.bakaflan.di.annotation.Inject;
import com.bakaflan.di.exception.CreatInstanceErrorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassHelper {
    public static Constructor<?>  pickInjectableConstructor(Class<?> clazz) {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        List<Constructor<?>> constructors = Arrays.stream(declaredConstructors)
                .filter(item -> Modifier.isPublic(item.getModifiers()))
                .filter(item -> item.getParameterCount() == 0 || item.isAnnotationPresent(Inject.class))
                .collect(Collectors.toList());
        if (constructors.size() != 1) {
            throw new CreatInstanceErrorException("Make sure Class: " + clazz.getSimpleName() +
                    " has at least one public injectable constructor");
        }
        return constructors.get(0);
    }
}
