package cvr.otus.service;

import cvr.otus.domain.Author;

import java.util.List;

public interface AuthorService {
    Author add(String name);

    List<Author> getAll();

    Author get(int id);

}
