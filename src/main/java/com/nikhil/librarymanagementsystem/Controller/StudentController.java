package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateResponseDTO;
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

    @GetMapping("/get_users")
    public List<Student> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/get_user")
    public Student getUser(@RequestParam("id") int id){
        return service.getUser(id);
    }

    //Get all students by Name
    @GetMapping("/get-name")
    public List<Student> getName(@RequestParam String name){
        return service.getName(name);
    }

    @GetMapping("/find-by-email")
    public Student findByEmail(@RequestParam String email){
        return service.findByEmail(email);
    }

    @GetMapping("/find-by-age")
    public List<Student> findByAge(int age){
        return service.findByAge(age);
    }

    @PutMapping("/update-email")
    public StudentEmailUpdateResponseDTO sendRequestDTO(@RequestBody int id, String new_email){
        StudentEmailUpdateRequestDTO studentEmailUpdateRequestDTO=new StudentEmailUpdateRequestDTO();
        studentEmailUpdateRequestDTO.setId(id);
        studentEmailUpdateRequestDTO.setEmail(new_email);
        return service.updateResponseDTO(studentEmailUpdateRequestDTO);
    }
}