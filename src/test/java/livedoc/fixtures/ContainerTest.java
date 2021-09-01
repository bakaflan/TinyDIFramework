package livedoc.fixtures;

import com.bakaflan.di.ClassUtils;
import com.bakaflan.di.Container;
import com.bakaflan.di.example.Foo;
import com.bakaflan.di.exception.CreatInstanceErrorException;
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

    public void putNamedClass(String className) throws ClassNotFoundException {
        container.putNamedClass(ClassUtils.getClassByName(className));
    }

    public String getCircleDependInstance(String className) {
        try {
            container.getInstance(ClassUtils.getClassByName(className));
            return "创建实例成功";
        } catch (CreatInstanceErrorException | ClassNotFoundException e) {
            return "创建实例失败";
        }
    }

    public String getClassName(Object clazz) {
        return clazz.getClass().getSimpleName();
    }

    public boolean isSame(Foo foo) {
        return foo.isSame();
    }
}
