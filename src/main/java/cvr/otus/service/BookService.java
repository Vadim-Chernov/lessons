package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

public interface BookService extends BaseService<Book> {
    Book addAuthor(Book book, Author author);

    Book addGenre(Book book, Genre genre);

    Book removeAuthor(Book book, Author author);

    Book removeGenre(Book book, Genre genre);

}
