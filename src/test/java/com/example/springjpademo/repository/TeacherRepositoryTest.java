package com.example.springjpademo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository tRepository;

    @Test
    @Transactional
    public void saveTeacher() {
        // Course course = Course.builder().title("Spring Data JPA").credit(5).build();
        Course course1 = Course.builder().title("Spring Boot").credit(5).build();
        Course course2 = Course.builder().title("Spring Authentication").credit(5).build();
        // Teacher teacher = Teacher.builder().firstName("Daily Code").lastName("Buffer").courses(List.of(course1, course2)).build();
        // tRepository.save(teacher);
    }

    @Test
    @Transactional
    public void saveTeacherWithTransaction(){
        Teacher teacher = Teacher.builder().firstName("Lenze").lastName("Tong").build();
        tRepository.save(teacher);
        Optional<Teacher> savedTeacher = tRepository.findById(teacher.getTeacherId());
        assertNotNull(savedTeacher.get());
        assertEquals(savedTeacher.get(), teacher);
    }
}
