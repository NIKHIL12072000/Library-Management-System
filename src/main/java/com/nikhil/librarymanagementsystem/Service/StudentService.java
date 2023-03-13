package com.nikhil.librarymanagementsystem.Service;

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


}
