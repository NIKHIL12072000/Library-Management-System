package com.nikhil.librarymanagementsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nikhil.librarymanagementsystem.Enum.Genre;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String title;

    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;

}