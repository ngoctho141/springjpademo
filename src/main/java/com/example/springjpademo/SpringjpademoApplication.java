package com.example.springjpademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springjpademo.entity.Student;
import com.example.springjpademo.repository.StudentRepository;

@SpringBootApplication
public class SpringjpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpademoApplication.class, args);
	}

	// @Bean
	// CommandLineRunner initDatabase(StudentRepository repository) {
	// 	return args -> repository
	// 			.save(Student.builder().emailId("thonn@gmail.com").firstName("Nguyen").lastName("Ngoc Tho").build());
	// }

}
