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
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Author get(String id) {
        return repository.getById(id);
    }


}
