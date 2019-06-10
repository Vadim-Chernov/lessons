package cvr.otus.service;

import cvr.otus.domain.Genre;
import cvr.otus.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return repository.save(name).block();
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> ret = new ArrayList<>();
        repository.findAll().map(genre -> ret.add(genre));
        return ret ;
    }

    @Override
    public Genre get(String id) {
        return repository.getById(id).block();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}

