package com.nikhil.librarymanagementsystem.Service;

import com.nikhil.librarymanagementsystem.DTO.AuthorRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.AuthorResponseDTO;
import com.nikhil.librarymanagementsystem.Entity.Author;
import com.nikhil.librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDTO addAuthor(AuthorRequestDTO authorRequestDTO) {
        Author author=new Author();
        author.setAge(authorRequestDTO.getAge());
        author.setName(authorRequestDTO.getName());
        author.setEmail(authorRequestDTO.getEmail());
        author.setMobNo(authorRequestDTO.getMobNo());

        authorRepository.save(author);

        AuthorResponseDTO authorResponseDTO=new AuthorResponseDTO(author.getName(), author.getEmail());
        return authorResponseDTO;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
}
