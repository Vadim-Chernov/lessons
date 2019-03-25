package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookRepository {

    Book getById(int id);

    Book add(String name);

    List<Book> getAll();

    Book addGenre(int book, int genre);

    Book addAuthor(int book, int author);

    Book removeGenre(int book, int genre);

    Book removeAuthor(int book, int author);
}
