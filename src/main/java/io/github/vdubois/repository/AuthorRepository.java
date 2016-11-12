package io.github.vdubois.repository;

import io.github.vdubois.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vdubois on 12/11/16.
 */
@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends PagingAndSortingRepository    <Author, Long> {
}
