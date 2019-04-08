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
        bookService.save(new Book(name));
    }


    @ShellMethod(value = "список книг", group = "Справочники")
    public void allBooks() {
        List<Book> all = bookService.findAll();
        for (Book book : all) {
            printService.printBook(book);
        }
    }

    @ShellMethod(value = "добавить автора к книге", group = "Работа с книгами")
    public void plusAuthor(@ShellOption Long b, @ShellOption Long a) {
        Book book1 = bookService.addAuthor(b, a);
        printService.printBook(book1);
    }
    @ShellMethod(value = "добавить автора к книге c b=9 и a=3", group = "Работа с книгами")
    public void pa() {
        Long b=9L;
        Long a=3L;
        Book book1 = bookService.addAuthor(b, a);
        printService.printBook(book1);
    }

    @ShellMethod(value = "добавить жанр к книге c b=9 и g=7", group = "Работа с книгами")
    public void pg() {
        Long b=9L;
        Long g=7L;
        Book book1 = bookService.addGenre(b, g);
        printService.printBook(book1);
    }


    @ShellMethod(value = "добавить жанр  к книге", group = "Работа с книгами")
    public void plusGenre(@ShellOption Long b,@ShellOption  Long g) {
        Book book1 = bookService.addGenre(b, g);
        printService.printBook(book1);
    }



}
