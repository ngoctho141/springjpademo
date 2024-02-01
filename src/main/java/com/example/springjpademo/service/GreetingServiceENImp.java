package com.example.springjpademo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service
@Slf4j
public class GreetingServiceENImp implements GreetingService{
    @Override
    public String greeting() {
        log.debug("greeting service is executed.");
        return "Hello!";
    }
}
