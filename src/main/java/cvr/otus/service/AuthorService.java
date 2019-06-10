package cvr.otus.service;

import cvr.otus.domain.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AuthorService {
    Author save(Author name);

    List<Author> findAll();

    Author get(String id);

    void deleteAll();
}
