package com.nikhil.librarymanagementsystem.Entity;

import com.nikhil.librarymanagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    private Date validTill;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @OneToOne
    @JoinColumn
    Student student;
}
