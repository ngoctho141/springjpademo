package com.example.springjpademo.repository;

import com.example.springjpademo.TestDataSourceConfig;
import com.example.springjpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = TestDataSourceConfig.class)
public class UserRepoSpringBootTest {

    @Autowired
    UserRepository userRepository;
    @Test
    @Transactional
    @Rollback
    void addUserTest() {
        User user = User.builder()
                .email("professional_ejb@example.com")
                .working(true)
                .age(25)
                .aboutMe("Not commited in the database")
                .name("Nalaya Daktor")
                .build();
        try{
            addUserTestNewTransactionContext();
        } catch (Exception e){

        }
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void addUserTestNewTransactionContext(){
        User user = User.builder()
                .email("professional_ejb2@example.com")
                .working(true)
                .age(25)
                .aboutMe("Committed to the database")
                .name("Sommi Kamu")
                .build();
        userRepository.save(user);
        throw new RuntimeException(" Simulating an error");
    }

}
