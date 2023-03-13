package com.nikhil.librarymanagementsystem.Entity;

import com.nikhil.librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String TransactionNumber;
    @Enumerated(EnumType.STRING)
    TransactionStatus status;
    @ManyToOne
    @JoinColumn
    Book book;
    @ManyToOne
    @JoinColumn
    LibraryCard card;

}
