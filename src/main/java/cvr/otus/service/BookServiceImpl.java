package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.AuthorRepository;
import cvr.otus.repo.BookRepository;
import cvr.otus.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }


    @Override
    public Book addAuthor(String book, String author) {
        return repository.addAuthor(book, author);
    }

    @Override
    public Book addGenre(String book, String genre) {
        return repository.addGenre(book, genre);
    }

    @Override
    public Book removeAuthor(String book,  String author) {
        return repository.removeAuthor(book, author);
    }

    @Override
    public Book removeGenre(String book, String genre) {
        return repository.removeGenre(book, genre);
    }

    @Override
    public List<Author> notAuthors(String book_id) {
        if(book_id==null)
            return authorRepository.findAll();
        List<Author> authors = repository.getById(book_id).getAuthors();
        List<Author> result = new ArrayList<>(10);
        for (Author author : authorRepository.findAll())
            if (!authors.contains(author))
                result.add(author);
        return result;
    }

    @Override
    public List<Genre> notGenres(String book_id) {
        if(book_id==null)
            return genreRepository.findAll();;
        Book book = repository.getById(book_id);
        List<Genre> genres = book.getGenres();
        List<Genre> list = genreRepository.findAll();
        List<Genre> result = new ArrayList<>(list.size());
        for(Genre genre : list)
            if(!genres.contains(genre))
                result.add(genre);
        return result;
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
    public Book get(String id) {
        return repository.getById(id);
    }

    @Override
    public void remove(String id) {
        Book book = repository.getById(id);
        if (book != null)
            repository.delete(book);
    }


}
