package com.nikhil.librarymanagementsystem.Controller;

import com.nikhil.librarymanagementsystem.Entity.Book;
import com.nikhil.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/books")
public class BookController{
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book){

        try{
            bookService.addBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()+"Book not added");
        }

        return "Book added successfully";
    }

    //API to get all books
}
