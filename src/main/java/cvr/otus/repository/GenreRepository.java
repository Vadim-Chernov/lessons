package cvr.otus.repository;

import cvr.otus.domain.Genre;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

    Mono<Genre> getById(String id);

    @SuppressWarnings("unchecked")
    Mono<Genre> save(Genre name);


}
