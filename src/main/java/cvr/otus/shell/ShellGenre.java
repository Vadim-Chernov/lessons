package cvr.otus.shell;

import cvr.otus.domain.Genre;
import cvr.otus.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ShellGenre {
    private final GenreService genreService;

    @Autowired
    public ShellGenre(GenreService genreService) {
        this.genreService = genreService;
    }


    @ShellMethod(value = "добавить жанр", group = "Справочники")
    public void addGen(@ShellOption String name) {
        genreService.add(name);
    }

    @ShellMethod(value = "список жанров", group = "Справочники")
    public void allGen() {
        List<Genre> all = genreService.getAll();
        for (Genre genre : all) {
            System.out.println(genre);
        }
    }


}
