package io.github.vdubois.controller;

import io.github.vdubois.model.Book;
import io.github.vdubois.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    public ResponseEntity<Book> findBookByIsbn(@PathVariable("isbn") String isbn) {
        Book book = bookService.findOneByIsbn(isbn);
        return Optional.ofNullable(book)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
