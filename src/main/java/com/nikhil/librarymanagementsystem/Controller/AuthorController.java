package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.DTO.AuthorRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.AuthorResponseDTO;
import com.nikhil.librarymanagementsystem.Entity.Author;
import com.nikhil.librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add-author")
    public AuthorResponseDTO addAuthor(@RequestBody AuthorRequestDTO authorRequestDTO){
        return authorService.addAuthor(authorRequestDTO);
    }

    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
}