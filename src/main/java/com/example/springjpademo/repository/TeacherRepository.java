package com.example.springjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpademo.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
