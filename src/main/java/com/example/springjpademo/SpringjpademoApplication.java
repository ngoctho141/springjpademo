package com.example.springjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjpademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjpademoApplication.class, args);
    }

//	 @Bean
//	 CommandLineRunner initDatabase(StudentRepository repository) {
//	 	return args -> repository
//	 			.save(Student.builder().emailId("thonn@gmail.com").firstName("Nguyen").lastName("Ngoc Tho").build());
//	 }

}
