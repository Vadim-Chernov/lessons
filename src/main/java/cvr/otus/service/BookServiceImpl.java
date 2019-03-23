package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book addAuthor(Book book, Author author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book addGenre(Book book, Genre genre) {
        return repository.addGenre(book, genre);
    }

    @Override
    public Book removeAuthor(Book book, Author author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book removeGenre(Book book, Genre genre) {
        return repository.removeGenre(book, genre);
    }

    @Override
    public Book add(String name) {
        return repository.add(name);
    }

    @Override
    public List<Book> getAll() {
        return repository.getAll();
    }

    @Override
    public Book get(int id) {
        return repository.getById(id);
    }
}
