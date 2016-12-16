create table IF NOT EXISTS books (
  id int not null PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  publicationDate DATE NOT NULL,
  price DOUBLE NOT NULL,
  editor VARCHAR(255) NOT NULL,
  numberOfPages INT NOT NULL,
  isbn VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS authors (
  id int NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS books_authors (
  book_id INT NOT NULL REFERENCES books(id),
  author_id INT NOT NULL REFERENCES authors(id)
);
