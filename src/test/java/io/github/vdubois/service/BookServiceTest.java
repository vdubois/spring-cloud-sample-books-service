package io.github.vdubois.service;

import io.github.vdubois.model.Author;
import io.github.vdubois.model.Book;
import io.github.vdubois.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vdubois on 27/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        jdbcTemplate.update("DELETE FROM books_authors");
        jdbcTemplate.update("DELETE FROM authors");
        jdbcTemplate.update("DELETE FROM books");
    }

    @Test
    public void should_find_one_book_by_isbn_work() {
        // GIVEN
        Book book = createEffectiveJava();
        Book book2 = createContinuousDelivery();

        // WHEN
        Book foundBook = bookRepository.findOneByIsbn(book.getIsbn());

        // THEN
        assertThat(foundBook.getName()).isEqualTo("Effective Java");
    }

    @Test
    public void should_fail_to_create_book_if_bad_isbn() {
        // GIVEN
        Book book = initEffectiveJava();
        book.setIsbn("123456");

        // WHEN
        catchException(bookRepository).save(book);

        // THEN
        assertThat((Throwable) caughtException())
                .isNotNull()
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("Bad ISBN number");
    }

    private Book createContinuousDelivery() {
        Book book = new Book();
        book.setName("Continuous Delivery");
        book.setPrice(new BigDecimal("29.99"));
        book.setNumberOfPages(280);
        book.setPublicationDate(Date.from(Instant.now()));
        book.setEditor("Packt");
        book.setIsbn("0321601912");
        Author author = new Author();
        author.setName("Martin Fowler");
        book.addAuthor(author);
        return null;
    }


    private Book createEffectiveJava() {
        Book book = initEffectiveJava();
        bookRepository.save(book);
        return book;
    }

    private Book initEffectiveJava() {
        Book book = new Book();
        book.setName("Effective Java");
        book.setPrice(new BigDecimal("29.99"));
        book.setNumberOfPages(280);
        book.setPublicationDate(Date.from(Instant.now()));
        book.setEditor("Packt");
        book.setIsbn("1449374646");
        Author author = new Author();
        author.setName("Joshua Bloch");
        book.addAuthor(author);
        return book;
    }
}