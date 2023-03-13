package com.nikhil.librarymanagementsystem.Service;

import com.nikhil.librarymanagementsystem.Entity.Author;
import com.nikhil.librarymanagementsystem.Entity.Book;
import com.nikhil.librarymanagementsystem.Repository.AuthorRepository;
import com.nikhil.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book) throws Exception {

        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            return "Book not added";
        }

        List<Book> booksWritten = author.getBooks();
        booksWritten.add(book);

        authorRepository.save(author);
        return "Book added";
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
