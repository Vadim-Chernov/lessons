package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.AuthorRepository;
import cvr.otus.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
//    @Transactional
    public Book addAuthor(Long book, Long author) {
//        Book book1 = repository.getById(book.getId());
//        Author author1 = authorRepository.getById(author.getId());
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
        return repository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book get(Long id) {
        return repository.getById(id);
    }

    @Override
    public void remove(Long id) {
        Book book = repository.getById(id);
        if (book != null)
            repository.delete(book);
    }
}
