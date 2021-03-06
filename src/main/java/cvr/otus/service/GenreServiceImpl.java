package cvr.otus.service;

import cvr.otus.domain.Genre;
import cvr.otus.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository repository;

    @Autowired
    public GenreServiceImpl(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Genre add(String name) {
        return repository.add(name);
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> all = repository.getAll();
        return all;
    }

    @Override
    public Genre get(int id) {
        return repository.getById(id);
    }
}

