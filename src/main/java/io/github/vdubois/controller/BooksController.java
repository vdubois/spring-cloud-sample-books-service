package io.github.vdubois.controller;

import io.github.vdubois.model.Book;
import io.github.vdubois.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vdubois on 03/12/16.
 */
@RestController
public class BooksController {

    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{isbn}")
    public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.findOneByIsbn(isbn);
    }
}
