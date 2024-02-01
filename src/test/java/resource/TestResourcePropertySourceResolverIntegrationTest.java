package resource;

import com.example.springjpademo.PropertySourceResolver;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PropertySourceResolver.class)
@EnableWebMvc
public class TestResourcePropertySourceResolverIntegrationTest {

    @Autowired
    private PropertySourceResolver propertySourceResolver;

    @Value("${example.thirdProperty}")
    String thirdProperty;

    @Test
    public void shouldTestResourceFile_overridePropertyValues() {
        String firstProperty = propertySourceResolver.getFirstProperty();
        String secondProperty = propertySourceResolver.getSecondProperty();


        assertEquals("file", firstProperty);
        assertEquals("file", secondProperty);
        assertEquals("servlet", thirdProperty);
    }
}