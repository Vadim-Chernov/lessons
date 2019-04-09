package cvr.otus.service;

import cvr.otus.domain.Book;
import cvr.otus.dao.AuthorRepository;
import cvr.otus.dao.BookRepository;
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
    public Book addAuthor(Long book, Long author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book addGenre(Long book, Long genre) {
        return repository.addGenre(book, genre);
    }

    @Override
    public Book removeAuthor(Long book, Long author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book removeGenre(Long book, Long genre) {
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
