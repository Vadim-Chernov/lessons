package cvr.otus.shell;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.service.AuthorService;
import cvr.otus.service.BookService;
import cvr.otus.service.GenreService;
import cvr.otus.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ShellBook {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final PrintService printService;

    @Autowired
    public ShellBook(BookService bookService, AuthorService authorService, GenreService genreService, PrintService printService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.printService = printService;
    }

    @ShellMethod(value = "добавить книгу", group = "Работа с книгами")
    public void addBook(@ShellOption String name) {
        bookService.add(name);
    }


    @ShellMethod(value = "список книг", group = "Справочники")
    public void allBook() {
        List<Book> all = bookService.getAll();
        for (Book book : all) {
            printService.printBook(book);
        }
    }

    @ShellMethod(value = "добавить автора к книге", group = "Работа с книгами")
    public void plusAut(@ShellOption int b_id, @ShellOption int a_id) {
        Book book = bookService.get(b_id);
        Author author = authorService.get(a_id);
        Book book1 = bookService.addAuthor(book, author);
        printService.printBook(book1);
    }

    @ShellMethod(value = "добавить жанр  к книге", group = "Работа с книгами")
    public void plusGen(@ShellOption int b_id,@ShellOption  int g_id) {
        Book book = bookService.get(b_id);
        Genre genre = genreService.get(g_id);
        Book book1 = bookService.addGenre(book, genre);
        printService.printBook(book1);
    }

}
