package com.example.springjpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpademo.entity.Guardian;
import com.example.springjpademo.entity.Student;

@SpringBootTest
// @DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;

    // @Test
    public void saveStudent() {
        Student student = Student.builder().emailId("thonn94@gmail.com").firstName("Nguyen").lastName("Ngoc Tho").build();
        repository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = repository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().email("tho.nguyen@possehl-analytics.com").mobile("+49 152 58 15 14 12").name("Nguyen Thuy Ngan").build();
        Student student = Student.builder().firstName("Dang").lastName("Cong Tung").emailId("congtung@gmail.com").guardian(guardian).build();
        repository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = repository.findByFirstName("Nguyen");
        System.out.println("students = " + students);        
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = repository.getStudentByEmailAddress("thonn@gmail.com");

        System.out.println("student by email address = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        repository.updateStudentNameByEmailId("Le", "thonn@gmail.com");
    }

    @Test
    public void updateStudentLastNameByEmailIdTest(){
        
    }
}
