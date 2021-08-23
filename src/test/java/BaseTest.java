import com.bakaflan.di.CircleDependOne;
import com.bakaflan.di.Container;
import com.bakaflan.di.Foo;
import com.bakaflan.di.exception.CreatInstanceErrorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseTest {
    @Test
    void should_get_right_class_instance() {
        Container container = new Container();
        Foo instance = container.getInstance(Foo.class);
        assertEquals(instance.getClass().getSimpleName(), "Foo");
        assertNotNull(instance.getBoo());
    }

    @Test
    void should_throw_error_when_circle_depend() {
        Container container = new Container();
        assertThrows(CreatInstanceErrorException.class, () -> container.getInstance(CircleDependOne.class));
    }
}
