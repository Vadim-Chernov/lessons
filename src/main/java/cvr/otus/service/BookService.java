package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Book get(String id);

    void remove(String id);

    Book addAuthor(String book_id, String author_id);

    Book addGenre(String book_id, String genre_id);

    Book removeAuthor(String book_id, String author_id);

    Book removeGenre(String book_id, String genre_id);

    List<Author> notAuthors(String book_id);

    List<Genre> notGenres(String book_id);

}
