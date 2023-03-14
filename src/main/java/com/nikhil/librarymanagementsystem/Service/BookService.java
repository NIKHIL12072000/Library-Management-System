package com.nikhil.librarymanagementsystem.Service;

import com.nikhil.librarymanagementsystem.DTO.BookRequestDTO;
import com.nikhil.librarymanagementsystem.DTO.BookResponseDTO;
import com.nikhil.librarymanagementsystem.DTO.StudentResponseDTO;
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

    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
        Book book=new Book();
        book.setTitle(bookRequestDTO.getTitle());
        Author author;
        try {
            author = authorRepository.findById(bookRequestDTO.getAuthorId()).get();
        }
        catch(Exception e){
            return null;
        }
        book.setAuthor(author);
        book.setPrice(bookRequestDTO.getPrice());
        book.setGenre(bookRequestDTO.getGenre());

        List<Book> booksWritten = author.getBooks();
        booksWritten.add(book);

        authorRepository.save(author);

        BookResponseDTO bookResponseDTO=new BookResponseDTO();
        bookResponseDTO.setPrice(book.getPrice());
        bookResponseDTO.setTitle(book.getTitle());
        return bookResponseDTO;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
