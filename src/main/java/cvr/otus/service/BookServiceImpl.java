package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    public BookServiceImpl() {
    }
//    public BookServiceImpl(BookRepository repository, AuthorService authorService, GenreService genreService) {
//        this.repository = repository;
//        this.authorService = authorService;
//        this.genreService = genreService;
//    }


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
            return authorService.findAll();
        List<Author> authors = repository.getById(book_id).block().getAuthors();
        List<Author> result = new ArrayList<>(10);
        for (Author author : authorService.findAll())
            if (!authors.contains(author))
                result.add(author);
        return result;
    }

    @Override
    public List<Genre> notGenres(String book_id) {
        if(book_id==null)
            return genreService.findAll();;
        Book book = repository.getById(book_id).block();
        List<Genre> genres = book.getGenres();
        List<Genre> list = genreService.findAll();
        List<Genre> result = new ArrayList<>(list.size());
        for(Genre genre : list)
            if(!genres.contains(genre))
                result.add(genre);
        return result;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book).block();
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        repository.findAll().map(book -> books.add(book));
        return books;
    }

    @Override
    public Book get(String id) {
        return repository.getById(id).block();
    }

    @Override
    public void remove(String id) {
        Book book = repository.getById(id).block();
        if (book != null)
            repository.delete(book);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
