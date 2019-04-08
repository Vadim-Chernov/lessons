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
    public Genre save(Genre name) {
        return repository.save(name);
    }

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }

    @Override
    public Genre get(Long id) {
        return repository.getById(id);
    }
}

