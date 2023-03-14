package com.nikhil.librarymanagementsystem.Entity;

import com.nikhil.librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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
    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssuedOperation; //issue or return books
    @ManyToOne
    @JoinColumn
    Book book;
    @ManyToOne
    @JoinColumn
    LibraryCard card;

}
