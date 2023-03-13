package com.nikhil.librarymanagementsystem.Entity;

import com.nikhil.librarymanagementsystem.Enum.CardStatus;
import com.nikhil.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    Department department;
    private String email;

    //Bidirectional Mapping is set up using @mappedBy
    //https://www.baeldung.com/jpa-joincolumn-vs-mappedby

    /*@JoinColumn is used to set up relation between student and card by adding
    student id as foreign key referencing to primary key of student table. Child
    Schema is affected*/

    /*mappedBy is used on parent side to map student with his card.
    It does not add any card_id column in student table, but the student
    and card are mapped internally. Parent schema is not affected
    Thus Bidirectional Mapping is achieved. It is optional. But saves effort*/

    /*If we don't write mapped by here(in parent class) it will be
    Unidirectional Mapping. It is mandatory*/

    /*CascadeType.ALL says that all the operations performed on
    parent table also applies on child table. So we need not separately
    save card details into card table. On saving Student details into
    student table card details are automatically saved into card table.
    If this not written we need to write cardRepository.save();
     */

    /*mappedBy is used to specify that card is mapped to student
    variable in LibraryCard class(child)
    * */

    /*we cant have attribute of child in parent. because parent is
    * independent and child is dependent. If we add child attribute
    * to parent table it makes parent table dependent on child table*/

    //this annotation only helps in saving the card details without
    //creating cardrepository class or else everything is same
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard card; //confined only to operation. connected logically but not present in student table physically

}