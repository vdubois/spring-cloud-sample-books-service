package io.github.vdubois.service;

import io.github.vdubois.model.Book;
import io.github.vdubois.repository.BookRepository;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public Book findOneByIsbn(String isbn) {
        return bookRepository.findOneByIsbn(isbn);
    }
}
