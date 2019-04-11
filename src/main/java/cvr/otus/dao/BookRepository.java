package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookRepository {
    Book createNew(String name);

    List<Book> findAll();

    Book getById(Long id);

    Book getByName(String name);

    Book addAuthor(Book book, Author author);

    Book addGenre(Book book, Genre genre);


    Book removeAuthor(Book book, Author author);

    Book removeGenre(Book book, Genre genre);

}
