package cvr.otus.repo;

import cvr.otus.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

    Mono<Genre> getById(String id);

    @SuppressWarnings("unchecked")
    Mono<Genre> save(Genre name);


}
