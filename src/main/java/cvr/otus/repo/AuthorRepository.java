package cvr.otus.repo;

import cvr.otus.domain.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

    Mono<Author> getById(String id);

    @SuppressWarnings("unchecked")
    Mono<Author> save(Author author);


}
