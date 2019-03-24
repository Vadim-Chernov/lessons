package cvr.otus.shell;

import cvr.otus.domain.Author;
import cvr.otus.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ShellAuthor {
    private final AuthorService authorService;

    @Autowired
    public ShellAuthor(AuthorService authorService) {
        this.authorService = authorService;
    }


    @ShellMethod(value = "добавить автора", group = "Справочники")
    public void addAuthor(@ShellOption String name) {
        authorService.add(name);
    }


    @ShellMethod(value = "список авторов", group = "Справочники")
    public void allAuthors() {
        List<Author> all = authorService.getAll();
        for (Author author : all) {
            System.out.println(author);
        }
    }

}
