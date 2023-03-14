package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.DTO.BookRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.BookResponseDTO;
import com.nikhil.librarymanagementsystem.Entity.Book;
import com.nikhil.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/books")
public class BookController{
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public BookResponseDTO addBook(@RequestBody BookRequestDTO bookRequestDTO){
        return bookService.addBook(bookRequestDTO);
    }

    @GetMapping("/get-books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
}
