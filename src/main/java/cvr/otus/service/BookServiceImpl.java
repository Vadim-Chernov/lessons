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
    public Book addAuthor(int book, int author) {
//        Book book1 = repository.getById(book.getId());
//        Author author1 = authorRepository.getById(author.getId());
        return repository.addAuthor(book, author);
    }

    @Override
    public Book addGenre(int book, int genre) {
        return repository.addGenre(book, genre);
    }

    @Override
    public Book removeAuthor(int book, int author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book removeGenre(int book, int genre) {
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
