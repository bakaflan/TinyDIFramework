package com.bakaflan.di;

import com.bakaflan.di.annotation.Inject;
import com.bakaflan.di.annotation.Singleton;
import com.bakaflan.di.exception.CreatInstanceErrorException;
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Container {
    private Set<Class<?>> registeredClasses = Collections.synchronizedSet(new HashSet<>());
    private Map<Class<?>, Object> singletonClasses = Collections.synchronizedMap(new HashMap<>());

    public <T> T getInstance(Class<T> clazz){
        Constructor<T> constructor = (Constructor<T>) ClassHelper.pickInjectableConstructor(clazz);
        if(clazz.isAnnotationPresent(Singleton.class)){
            Object singletonInstance = singletonClasses.get(clazz);
            if(Objects.nonNull(singletonInstance)){
                return (T) singletonInstance;
            }
        }

        registeredClasses.add(clazz);
        Object[] params = Arrays.stream(constructor.getParameters()).map(item -> {
            if(registeredClasses.contains(item.getType())){
                throw new CreatInstanceErrorException(String.format("Circle dependency for class %s", constructor.getDeclaringClass().getSimpleName()));
            }
            Class<?> temp = item.getType();
            return getInstance(temp);
        }).toArray();
        T result;
        try {
            result = constructor.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new CreatInstanceErrorException(String.format("Create instance error from %s constructor", constructor.getDeclaringClass().getSimpleName()));
        }
        registeredClasses.remove(clazz);
        if(clazz.isAnnotationPresent(Singleton.class)){
            singletonClasses.put(clazz, result);
        }
        return result;
    }
}
