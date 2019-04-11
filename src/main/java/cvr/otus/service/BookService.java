package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookService{
    Book save(Book book);

    List<Book> findAll();

    Book get(Long id);

    Book addAuthor(Book book_id, Author author_id);

    Book addGenre(Book book_id, Genre genre_id);

    Book removeAuthor(Book book_id, Author author_id);

    Book removeGenre(Book book_id, Genre genre_id);

}
