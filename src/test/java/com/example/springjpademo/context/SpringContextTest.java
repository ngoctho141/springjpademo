package com.example.springjpademo.context;

import com.example.springjpademo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class SpringContextTest {

    @Autowired
    ApplicationContext ctx;
    @Test
    void testBeanContext(){
        UserController userController = ctx.getBean(UserController.class);
        assertNotNull("user controller is not null",userController);
    }
}
