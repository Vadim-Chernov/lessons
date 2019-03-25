package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import org.junit.jupiter.api.Test;

@DisplayName("BookRepositoryImplTest интерграционный тест")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class BookRepositoryImplTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Test
    public void getById() {
        Book book = repository.add("123");
        Book byId = repository.getById(book.getId());
        assertEquals(book.getId(), byId.getId());
    }

    @Test
    public void add() {
        Book book = repository.add("123");
        Book byId = repository.getById(book.getId());
        assertEquals("123", byId.getName());
    }

    @Test
    public void getAll() {
        List<Book> all = repository.getAll();
        assertNotNull(all);
    }

    @Test
    public void addGenre() {
        Genre genre = genreRepository.add("genre");
        Book add = repository.add("book");
        Book book = repository.addGenre(add.getId(), genre.getId());
        assertEquals("genre", book.getGenres().get(0).getName());
    }

    @Test
    public void addAuthor() {
        Author author = authorRepository.add("author");
        Book book = repository.add("book");
        book = repository.addAuthor(book.getId(), author.getId());
        assertEquals("author", book.getAuthors().get(0).getName());
    }

    @Test
    public void removeGenre() {
        Genre genre = genreRepository.add("genre");
        Book book = repository.add("book");
        book = repository.addGenre(book.getId(), genre.getId());
        int size = book.getGenres().size();
        book = repository.removeGenre(book.getId(), genre.getId());
        assertEquals(size - 1, book.getGenres().size());
    }

    @Test
    public void removeAuthor() {
        Author author = authorRepository.add("author");
        Book book = repository.add("book");
        book = repository.addAuthor(book.getId(),author.getId());
        int size = book.getAuthors().size();
        book = repository.removeAuthor(book.getId(),author.getId());
        assertEquals(size - 1, book.getAuthors().size());
    }
}