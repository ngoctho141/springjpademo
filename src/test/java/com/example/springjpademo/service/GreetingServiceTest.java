package com.example.springjpademo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ActiveProfiles("VN")
@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    GreetingService greetingService;
    @Test
    void testGreetingService(){
        assertEquals("", "Chao!", greetingService.greeting());
    }
}
