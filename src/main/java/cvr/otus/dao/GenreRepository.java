package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Genre;

import java.util.List;

public interface GenreRepository {
    Genre createNew(String name);

    List<Genre> findAll();

    Genre getById(Long id);

    Genre getByName(String name);
}
