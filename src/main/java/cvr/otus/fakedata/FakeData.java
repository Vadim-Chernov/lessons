package cvr.otus.fakedata;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repository.AuthorRepository;
import cvr.otus.repository.BookRepository;
import cvr.otus.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class FakeData {


    private Author[] authors = new Author[3];
    private Genre[] genres = new Genre[3];
    private Book[] books = new Book[3];

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public FakeData(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    @Autowired

    public void fillDB() {
        clearTables();
        fakeAuthors();
        fakeGenres();
        fakeBooks();
    }

    private void clearTables() {
        authorRepository.deleteAll();
        bookRepository.deleteAll();
        genreRepository.deleteAll();

    }

    private void fakeAuthors() {
        authors[0] = new Author("Ivanov");
        authors[1] = new Author("Petrov");
        authors[2] = new Author("Sidorov");
        authors[0] = authorRepository.save(authors[0]).block();
        authors[1] = authorRepository.save(authors[1]).block();
        authors[2] = authorRepository.save(authors[2]).block();
    }

    private void fakeGenres() {
        genres[0] = new Genre("Детектив");
        genres[1] = new Genre("Анекдот");
        genres[2] = new Genre("Публицистика");
        genres[0] = genreRepository.save(genres[0]).block();
        genres[1] = genreRepository.save(genres[1]).block();
        genres[2] = genreRepository.save(genres[2]).block();
    }

    private void fakeBooks() {
        books[0] = new Book("M-412", "Как ремонтировать машину Москвич", authors, genres);
        books[1] = new Book("Анекдот", "Про Петьку", new Author[]{authors[0], authors[1]}, new Genre[]{genres[1]});
        books[2] = new Book("Публицистика");
        books[0] = bookRepository.save(books[0]).block();
        books[1] = bookRepository.save(books[1]).block();
        books[2] = bookRepository.save(books[2]).block();
        System.out.println("Сохранение книги "+ "Ivanov".equals(books[0].getAuthors().get(0).getName()));
    }
}
