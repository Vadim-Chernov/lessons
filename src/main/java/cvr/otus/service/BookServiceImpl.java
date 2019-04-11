package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.dao.AuthorRepository;
import cvr.otus.dao.BookRepository;
import cvr.otus.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;


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
        return repository.removeAuthor(book, author);
    }

    @Override
    public Book removeGenre(Book book, Genre genre) {
        return repository.removeGenre(book, genre);
    }

    @Override
    public Book save(Book book) {
        return repository.createNew(book.getName());
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book get(Long id) {
        return repository.getById(id);
    }
}
