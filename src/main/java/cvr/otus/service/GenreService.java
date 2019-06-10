package cvr.otus.service;

import cvr.otus.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre save(Genre name);

    List<Genre> findAll();

    Genre get(String id);

    void deleteAll();

}
