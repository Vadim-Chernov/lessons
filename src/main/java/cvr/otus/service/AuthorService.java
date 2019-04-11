package cvr.otus.service;

import cvr.otus.domain.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author name);

    List<Author> findAll();

    Author get(Long id);

}
