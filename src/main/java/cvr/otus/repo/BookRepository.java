package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookRepository {

    Book getById(int id);

    Book add(String name);

    List<Book> getAll();

    Book addGenre(Book book, Genre genre);

    Book addAuthor(Book book, Author author);

    Book removeGenre(Book book, Genre genre);

    Book removeAuthor(Book book, Author author);
}
