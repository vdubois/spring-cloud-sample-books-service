package io.github.vdubois.controller;

import io.github.vdubois.model.Book;
import io.github.vdubois.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vdubois on 03/12/16.
 */
@RestController
public class BooksController {

    private BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/{isbn}")
    public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookRepository.findOneByIsbn(isbn);
    }
}
