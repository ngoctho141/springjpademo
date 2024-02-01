package com.example.springjpademo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile("VN")
@Service
public class GreetingServiceVNImp implements GreetingService{
    @Override
    public String greeting() {
        return "Chao!";
    }
}
