package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.Entity.Student;
import com.nikhil.librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    /*@GetMapping("/get_users")
    public List<Student> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/get_user")
    public Student getUser(@RequestParam("id") int id){
        return service.getUser(id);
    }*/
    //Get all students by Name
}