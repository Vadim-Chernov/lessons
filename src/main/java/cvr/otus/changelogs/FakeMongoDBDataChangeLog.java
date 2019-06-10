package cvr.otus.changelogs;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.service.AuthorService;
import cvr.otus.service.BookService;
import cvr.otus.service.GenreService;
import org.springframework.context.ApplicationContext;

public class FakeMongoDBDataChangeLog {


    private Author[] authors = new Author[3];
    private Genre[] genres = new Genre[3];
    private Book[] books = new Book[3];

    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;

    public FakeMongoDBDataChangeLog(ApplicationContext context) {

        this.authorService = context.getBean(AuthorService.class);
        this.bookService = context.getBean(BookService.class);;
        this.genreService = context.getBean(GenreService.class);;
    }

    public void fillDB() {
        clearTables();
        fakeAuthors();
        fakeGenres();
        fakeBooks();
    }

    private void clearTables() {
        authorService.deleteAll();
        bookService.deleteAll();
        genreService.deleteAll();

    }

    private void fakeAuthors() {
        authors[0] = new Author("Ivanov");
        authors[1] = new Author("Petrov");
        authors[2] = new Author("Sidorov");
        authors[0] = authorService.save(authors[0]);
        authors[1] = authorService.save(authors[1]);
        authors[2] = authorService.save(authors[2]);
    }

    private void fakeGenres() {
        genres[0] = new Genre("Детектив");
        genres[1] = new Genre("Анекдот");
        genres[2] = new Genre("Публицистика");
        genres[0] = genreService.save(genres[0]);
        genres[1] = genreService.save(genres[1]);
        genres[2] = genreService.save(genres[2]);
    }

    private void fakeBooks() {
        books[0] = new Book("M-412", "Как ремонтировать машину Москвич", authors, genres);
        books[1] = new Book("Анекдот", "Про Петьку", new Author[]{authors[0], authors[1]}, new Genre[]{genres[1]});
        books[2] = new Book("Публицистика");
        books[0] = bookService.save(books[0]);
        books[1] = bookService.save(books[1]);
        books[2] = bookService.save(books[2]);
    }
}
