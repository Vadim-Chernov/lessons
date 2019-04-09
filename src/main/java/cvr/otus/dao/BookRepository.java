package cvr.otus.dao;

import cvr.otus.domain.Book;

import java.util.List;

public interface BookRepository {
    Book createNew(String name);

    List<Book> findAll();

    Book getById(Long id);

    Book getByName(String name);

    Book addAuthor(Long book_id, Long author_id);

    Book addGenre(Long book_id, Long genre_id);

    Book removeAuthor(Long book_id, Long author_id);

    Book removeGenre(Long book_id, Long genre_id);

}
