package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

import java.util.List;

public interface BookService{
    Book add(String name);

    List<Book> getAll();

    Book get(int id);

    Book addAuthor(Book book, Author author);

    Book addGenre(Book book, Genre genre);

    Book removeAuthor(Book book, Author author);

    Book removeGenre(Book book, Genre genre);

}
