package com.nikhil.librarymanagementsystem.Repository;

import com.nikhil.librarymanagementsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{

}
