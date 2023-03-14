package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateResponseDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentResponseDTO;
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
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return service.addStudent(studentRequestDTO);
    }

    @GetMapping("/get-students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @GetMapping("/get-student-by-id")
    public Student getStudentById(@RequestParam("id") int id){
        return service.getStudentById(id);
    }

    @GetMapping("/get-student-by-name")
    public List<Student>  getAllStudentsByName(@RequestParam String name){
        return service. getAllStudentsByName(name);
    }

    @GetMapping("/find-by-email")
    public Student findByEmail(@RequestParam String email){
        return service.findByEmail(email);
    }

    @GetMapping("/find-by-age")
    public List<Student> findByAge(@RequestParam int age){
        return service.findByAge(age);
    }

    @PutMapping("/update-email")
    public StudentEmailUpdateResponseDTO sendUpdateEmailRequestDTO(@RequestBody StudentEmailUpdateRequestDTO studentEmailUpdateRequestDTO){
        return service.sendUpdateEmailRequestDTO(studentEmailUpdateRequestDTO);
    }
}