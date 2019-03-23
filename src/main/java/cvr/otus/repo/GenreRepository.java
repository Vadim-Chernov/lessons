package cvr.otus.repo;

import cvr.otus.domain.Genre;

import java.util.List;

public interface GenreRepository {

    Genre getById(int id);

    Genre add(String name);

    List<Genre> getAll();
}
