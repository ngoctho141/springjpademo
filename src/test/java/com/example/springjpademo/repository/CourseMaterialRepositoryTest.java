package com.example.springjpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository cMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().title("Computer Science").credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().course(course).url("www.google.com").build();

        cMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> coursematerials = cMaterialRepository.findAll();
        System.out.println("all course materials = " + coursematerials);
    }
}
