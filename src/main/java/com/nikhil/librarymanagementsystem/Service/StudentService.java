package com.nikhil.librarymanagementsystem.Service;

import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateResponseDTO;
import com.nikhil.librarymanagementsystem.Entity.LibraryCard;
import com.nikhil.librarymanagementsystem.Entity.Student;
import com.nikhil.librarymanagementsystem.Enum.CardStatus;
import com.nikhil.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        Date today=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.YEAR,4);
        Date exp_date=calendar.getTime();
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setStatus(CardStatus.ACTIVATED);
        libraryCard.setValidTill(exp_date);
        libraryCard.setStudent(student);
        student.setCard(libraryCard);
        studentRepository.save(student);
        return "Student Details Saved";
    }

    public Student findByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public List<Student> findByAge(int age){
        return studentRepository.findByAge(age);
    }

    public StudentEmailUpdateResponseDTO updateResponseDTO(StudentEmailUpdateRequestDTO studentEmailUpdateRequestDTO){
        Student student=studentRepository.findById(studentEmailUpdateRequestDTO.getId()).get();
        student.setEmail(studentEmailUpdateRequestDTO.getEmail());

        Student updateStudent=studentRepository.save(student);

        StudentEmailUpdateResponseDTO updateResponseDTO=new StudentEmailUpdateResponseDTO();
        updateResponseDTO.setId(updateStudent.getId());
        updateResponseDTO.setEmail(updateStudent.getEmail());
        updateResponseDTO.setName(updateStudent.getName());

        return updateResponseDTO;
    }

    public List<Student> getUsers() {
        return studentRepository.findAll();
    }

    public Student getUser(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getName(String name) {
        return studentRepository.findByName(name);
    }
}
