package io.github.vdubois.repository;

import io.github.vdubois.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vdubois on 21/11/16.
 */
@Projection(name = "withAuthors", types = {Book.class})
public interface BookWithAuthorsProjection {

    String getName();

    Date getPublicationDate();

    @Value("#{target.authors.![name]}")
    String getAuthorsNames();

    BigDecimal getPrice();

    String getEditor();

    Integer getNumberOfPages();

    String getIsbn();
}
