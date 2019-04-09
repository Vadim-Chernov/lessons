package cvr.otus.dao;

import cvr.otus.domain.Author;

import java.util.List;

public interface AuthorRepository {
    Author save(String name);

    List<Author> findAll();

    Author getById(Long id);

    Author getByName(String name);
}