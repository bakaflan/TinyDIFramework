package livedoc.fixtures;

import com.bakaflan.di.ClassUtils;
import com.bakaflan.di.Container;
import com.bakaflan.di.example.Foo;
import com.thoughtworks.fusheng.integration.junit5.FuShengTest;

@FuShengTest
public class ContainerTest {

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

    public boolean isSame(Foo foo){
        return foo.isSame();
    }
}
