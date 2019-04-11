package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@JdbcTest
@Import({BookRepositoryImpl.class,GenreRepositoryImpl.class,AuthorRepositoryImpl.class})

public class BookRepositoryImplTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Test
    public void getById() {
        Book book = repository.createNew("123");
        Book byId = repository.getById(book.getId());
        assertEquals(book.getId(), byId.getId());
    }

    @Test
    public void add() {
        Book book = repository.createNew("123");
        Book byId = repository.getById(book.getId());
        assertEquals("123", byId.getName());
    }

    @Test
    public void getAll() {
        List<Book> all = repository.findAll();
        assertNotNull(all);
    }

    @Test
    public void addGenre() {
        Genre genre = genreRepository.createNew("genre");
        Book add = repository.createNew("book");
        Book book = repository.addGenre(add, genre);
        assertEquals("genre", book.getGenres().get(0).getName());
    }

    @Test
    public void addAuthor() {
        Author author = authorRepository.createNew("author");
        Book book = repository.createNew("book");
        book = repository.addAuthor(book, author);
        assertEquals("author", book.getAuthors().get(0).getName());
    }

    @Test
    public void removeGenre() {
        Genre genre = genreRepository.createNew("genre");
        Book book = repository.createNew ("book");
        book = repository.addGenre(book, genre);
        int size = book.getGenres().size();
        book = repository.removeGenre(book, genre);
        assertEquals(size - 1, book.getGenres().size());
    }

    @Test
    public void removeAuthor() {
        Author author = authorRepository.createNew("author");
        Book book = repository.createNew ("book");
        book = repository.addAuthor(book,author);
        int size = book.getAuthors().size();
        book = repository.removeAuthor(book,author);
        assertEquals(size - 1, book.getAuthors().size());
    }
}