package com.nikhil.librarymanagementsystem.Repository;

import com.nikhil.librarymanagementsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AuthorRepository extends JpaRepository<Author,Integer>{

}
