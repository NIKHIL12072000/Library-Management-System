package com.nikhil.librarymanagementsystem.Repository;

import com.nikhil.librarymanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
    List<Student> findByAge(int age);
    List<Student> findByName(String name);
}
