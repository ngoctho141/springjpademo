package com.example.springjpademo.controller;

import com.example.springjpademo.entity.Student;
import com.example.springjpademo.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;




//@RestController
@Slf4j
@Controller
@RequestMapping(path="/api/v1/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentRepository.findAll());
        log.debug("get student is called");
        log.debug("this controller is called");
        return "students";
    }

    @RequestMapping(value = "/saveStudent", method=RequestMethod.POST)
    public ResponseEntity<Student> requestMethodName(@RequestBody Student student) {
        studentRepository.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/student");
        System.out.println(student + " created");
        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);
    }

    @GetMapping("/student-list")
    public ResponseEntity<Student[]> getMethodName() {
        return new ResponseEntity<>((Student[])studentRepository.findAll().toArray(), HttpStatus.OK);
    }
    
    
    

    @RequestMapping(value = "/student/{studentId}", method= RequestMethod.GET)
    public String getStudent(Model model, @PathVariable("studentId") Long studentId){
        model.addAttribute("student", studentRepository.findById(studentId));
        return "student";
    }
}
