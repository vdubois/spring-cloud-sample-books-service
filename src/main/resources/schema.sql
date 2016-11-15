create table books (
  id int not null PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  publicationDate DATE NOT NULL,
  price DOUBLE NOT NULL,
  editor VARCHAR(255) NOT NULL,
  numberOfPages INT NOT NULL,
  isbn VARCHAR(50) NOT NULL
);

CREATE TABLE authors (
  id int NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE books_authors (
  book_id INT NOT NULL REFERENCES books(id),
  author_id INT NOT NULL REFERENCES authors(id)
);
