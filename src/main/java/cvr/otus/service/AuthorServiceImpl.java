package cvr.otus.service;

import cvr.otus.domain.Author;
import cvr.otus.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author add(String name) {
        return repository.add(name);
    }

    @Override
    public List<Author> getAll() {
        List<Author> all = repository.getAll();
        return all;
    }

    @Override
    public Author get(int id) {
        return repository.getById(id);
    }


}
