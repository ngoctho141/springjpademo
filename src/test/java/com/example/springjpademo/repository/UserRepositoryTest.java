package com.example.springjpademo.repository;

import com.example.springjpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//@SpringBootTest
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void saveUser() {
        User user = User.builder()
                .name("Donat")
                .aboutMe("We love IT")
                .email("alex_eichler@donat-it.de")
                .age(50)
                .working(true)
                .build();
        userRepository.save(user);
        assertNotNull(user.getUserId());
    }

    @Test
    void saveInvalidUser() {
        User user = User.builder()
                .name("Donat")
                .aboutMe("We love IT")
                .age(17)
                .email("nntho@donat-it.de")
                .working(true)
                .build();
        userRepository.save(user);
    }
}