package io.github.vdubois.service;

import io.github.vdubois.model.Book;
import io.github.vdubois.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vdubois on 07/12/16.
 */
@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "books", key = "#isbn")
    public Book findOneByIsbn(String isbn) {
        return bookRepository.findOneByIsbn(isbn);
    }
}
