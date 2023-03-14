package com.nikhil.librarymanagementsystem.DTO;

import com.nikhil.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDTO {
    private String name;
    private String email;
    private int age;
    private Department department;
}
