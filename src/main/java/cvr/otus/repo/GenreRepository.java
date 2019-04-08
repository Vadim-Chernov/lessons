package cvr.otus.repo;

import cvr.otus.domain.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre,Long> {

    Genre getById(Long id);

    @SuppressWarnings("unchecked")
    Genre save(Genre name);

    List<Genre> findAll();
}
