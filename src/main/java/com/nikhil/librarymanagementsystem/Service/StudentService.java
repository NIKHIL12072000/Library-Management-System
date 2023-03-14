package com.nikhil.librarymanagementsystem.Service;

import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentEmailUpdateResponseDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentResponseDTO;
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
    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        Date today=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.YEAR,4);
        Date exp_date=calendar.getTime();

        Student student=new Student();
        student.setEmail(studentRequestDTO.getEmail());
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setDepartment(studentRequestDTO.getDepartment());

        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setStatus(CardStatus.ACTIVATED);
        libraryCard.setValidTill(exp_date);
        libraryCard.setStudent(student);

        student.setCard(libraryCard);
        studentRepository.save(student);

        StudentResponseDTO studentResponseDTO=new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());

        return studentResponseDTO;
    }

    public Student findByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public List<Student> findByAge(int age){
        return studentRepository.findByAge(age);
    }

    public StudentEmailUpdateResponseDTO sendUpdateEmailRequestDTO(StudentEmailUpdateRequestDTO studentEmailUpdateRequestDTO){
        Student student=studentRepository.findById(studentEmailUpdateRequestDTO.getId()).get();
        student.setEmail(studentEmailUpdateRequestDTO.getEmail());

        Student updateStudent=studentRepository.save(student);

        StudentEmailUpdateResponseDTO updateResponseDTO=new StudentEmailUpdateResponseDTO();
        updateResponseDTO.setId(updateStudent.getId());
        updateResponseDTO.setEmail(updateStudent.getEmail());
        updateResponseDTO.setName(updateStudent.getName());

        return updateResponseDTO;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
}
