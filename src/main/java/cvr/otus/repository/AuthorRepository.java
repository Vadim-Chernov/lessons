package cvr.otus.repository;

import cvr.otus.domain.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

    Mono<Author> getById(String id);

    @SuppressWarnings("unchecked")
    Mono<Author> save(Author author);


}
