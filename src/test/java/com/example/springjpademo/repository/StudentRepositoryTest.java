package com.example.springjpademo.repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springjpademo.entity.Guardian;
import com.example.springjpademo.entity.Student;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
 @DataJpaTest
 @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityManager secondEntityManager;

    @PersistenceContext
    private EntityManager withPersistCtxtEM;

    @PersistenceUnit
    private EntityManager entityManager2;

     @Test
    public void saveStudent() {
        Student student = Student.builder().emailId("thonn94@gmail.com").firstName("Nguyen").lastName("Ngoc Tho").build();
        Student savedStudent = repository.save(student);
        Optional<Student> student1 = repository.findById(savedStudent.getStudentId());
        assertEquals(savedStudent.getEmailId(), student1.get().getEmailId());
         System.out.println(savedStudent);
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
        assertTrue(entityManager.contains(student)); // not managed by entity manager
        System.out.println("student by email address = " + student);
    }

    /**
     * test where the object returned by findById is managed by entity manager
     */
    @Test
    public void testEntityManager(){
        Optional<Student> st = repository.findById(1L);
        assertTrue(entityManager.contains(st.get()));
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        repository.updateStudentNameByEmailId("Le", "thonn@gmail.com");
    }

    @Test
    public void updateStudentLastNameByEmailIdTest(){
        
    }

    @Test
    @Rollback(false)
    public void saveStudentWithoutRollback(){
        Student student = Student.builder().firstName("Leitz")
                .lastName("Hocker")
                .emailId("leitz_hocker@donat-it.de")
                .build();
        repository.save(student);
    }

    /**
     * this test to demonstrate that an object return by findById managed automatically by only
     * one entity manager, in other word by only one session
     */
    @Test
    public void entityManagedByOne(){
        Optional<Student> st = repository.findById(1L);
        assertTrue(entityManager.contains(st.get()));
        assertTrue(secondEntityManager.contains(st.get()));
        assertEquals(entityManager, withPersistCtxtEM);
    }

}
