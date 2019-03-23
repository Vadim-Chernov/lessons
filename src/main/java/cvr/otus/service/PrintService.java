package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;

public interface PrintService {
    void printAuthor(Author author);

    void printGenre(Genre genre);

    void printBook(Book book);

}
