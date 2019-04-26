package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Book get(Long id);

    void remove(Long id);

    Book addAuthor(Long book_id, Long author_id);

    Book addGenre(Long book_id, Long genre_id);

    Book removeAuthor(Long book_id, Long author_id);

    Book removeGenre(Long book_id, Long genre_id);

    List<Author> notAuthors();

    List<Genre> notGenres();

}
