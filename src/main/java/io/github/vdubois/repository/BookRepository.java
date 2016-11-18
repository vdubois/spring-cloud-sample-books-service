package io.github.vdubois.repository;

import io.github.vdubois.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vdubois on 12/11/16.
 */
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Book findOneByIsbn(@Param(value = "isbn") String isbn);
}
