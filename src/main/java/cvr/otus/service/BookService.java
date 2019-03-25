package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookService{
    Book add(String name);

    List<Book> getAll();

    Book get(int id);

    Book addAuthor(int book_id, int author_id);

    Book addGenre(int book_id, int genre_id);

    Book removeAuthor(int book_id, int author_id);

    Book removeGenre(int book_id, int genre_id);

}
