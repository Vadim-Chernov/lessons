package cvr.otus.repo;

import cvr.otus.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre,String> {

    Genre getById(String id);

    @SuppressWarnings("unchecked")
    Genre save(Genre name);

    List<Genre> findAll();
}
