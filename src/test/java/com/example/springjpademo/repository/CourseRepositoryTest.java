package com.example.springjpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.Student;
import com.example.springjpademo.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository cRepository;

    @Test
    public void printCourses() {
        System.out.println("all courses = " + cRepository.findAll());
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("Posssehl").lastName("Analytics").build();
        Course course = Course.builder().title(".net").credit(10).teacher(teacher).build();
        cRepository.save(course);
    }

    @Test
    public void findAllWithPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        Long totalElements1 = cRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        Long totalElements2 = cRepository.findAll(secondPageWithTwoRecords).getTotalElements(); // same
        Integer totalPages1 = cRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        Integer totalPages2 = cRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        List<Course> courses = cRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").and(Sort.by("credit").descending()));
        List<Course> courses = cRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("all courses sorted by title and credit = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable secondPageWithTwoRecords = PageRequest.of(0, 10);

        List<Course> courses = cRepository.findByTitleContaining("D", secondPageWithTwoRecords).getContent();

        System.out.println("courses containing D with pageable = " + courses);
    }

    @Test
    public void saveCourseWithStudentsAndTeacher(){
        Teacher teacher = Teacher.builder().firstName("Stefan").lastName("Lang").build();
        Student student = Student.builder().firstName("Vu").lastName("Hoang").emailId("vu_hoang@gmail.com").build();
        Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();
        course.addStudent(student);
        cRepository.save(course);
    }

    @Test
    public void deleteCourse(){
        cRepository.deleteById(6L);
    }
}
