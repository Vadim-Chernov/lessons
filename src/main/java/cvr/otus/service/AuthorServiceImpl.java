package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author save(Author author) {
        return repository.save(author).block();
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        repository.findAll().map(author -> authors.add(author));
        return authors;
    }

    @Override
    public Author get(String id) {
        return repository.getById(id).block();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
