import com.bakaflan.di.Container;
import com.bakaflan.di.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseTest {
    @Test
    void should_get_right_class_instance() {
        Container container = new Container();
        Object instance = container.getInstance(Foo.class);
        Assertions.assertEquals(instance.getClass().getSimpleName(), "Foo");
    }


}
