package cvr.otus.service;

import cvr.otus.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre add(String name);

    List<Genre> getAll();

    Genre get(int id);
}
