package io.github.vdubois.init;

import io.github.vdubois.model.Author;
import io.github.vdubois.model.Book;
import io.github.vdubois.repository.AuthorRepository;
import io.github.vdubois.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by vdubois on 12/11/16.
 */
@Component
public class BooksInitializer implements CommandLineRunner {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public BooksInitializer(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Cloud Native Java,Josh Long|Kenny Bastani,31/01/2016,34.99,O'Reilly,256,1449374646").forEach(
                tuple -> {
                    String[] bookCaracteristics = tuple.split(",");
                    String isbn = bookCaracteristics[6];
                    Book foundBook = bookRepository.findOneByIsbn(isbn);
                    if (foundBook == null) {
                        Book book = new Book();
                        Arrays.stream(bookCaracteristics[1].split("\\|")).forEach(
                                authorName -> {
                                    Author author = new Author();
                                    author.setName(authorName);
                                    authorRepository.save(author);
                                    book.addAuthor(author);
                                }
                        );
                        book.setName(bookCaracteristics[0]);
                        book.setEditor(bookCaracteristics[4]);
                        book.setIsbn(bookCaracteristics[6]);
                        book.setNumberOfPages(Integer.valueOf(bookCaracteristics[5]));
                        book.setPrice(new BigDecimal(bookCaracteristics[3]));
                        SimpleDateFormat frenchFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                        try {
                            book.setPublicationDate(frenchFormat.parse(bookCaracteristics[2]));
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }
                        bookRepository.save(book);
                    }
                }
        );
    }
}
