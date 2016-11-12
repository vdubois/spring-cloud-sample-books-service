package io.github.vdubois;

import io.github.vdubois.init.BooksInitializer;
import io.github.vdubois.repository.AuthorRepository;
import io.github.vdubois.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudSampleBooksServiceApplication {

	@Bean
	public BooksInitializer booksInitializer(BookRepository bookRepository, AuthorRepository authorRepository) {
		return new BooksInitializer(bookRepository, authorRepository);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSampleBooksServiceApplication.class, args);
	}
}
