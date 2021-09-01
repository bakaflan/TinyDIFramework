package livedoc.fixtures;

import com.bakaflan.di.Container;
import com.bakaflan.di.ClassUtils;

public class BaseFixture {
    private Container container;

    public void initContainer() {
        container = new Container();
    }

    public Object getInstance(String className) throws ClassNotFoundException {
        return container.getInstance(ClassUtils.getClassByName(className));
    }

    public String getClassName(Object clazz) {
        return clazz.getClass().getSimpleName();
    }
}
