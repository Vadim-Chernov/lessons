package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrintServiceImpl implements PrintService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void printAuthor(Author author) {
        System.out.println(author.toString());
    }

    @Override
    public void printGenre(Genre genre) {
        System.out.println(genre.toString());
    }

    @Override
    public void printBook(Book b) {
        Book book = bookRepository.getById(b.getId());
        System.out.println(book.toString());
    }
}
