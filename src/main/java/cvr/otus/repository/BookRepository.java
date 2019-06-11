package cvr.otus.repository;

import cvr.otus.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {//], BookRepositoryCustom {

    Flux<Book> findAll();

    Mono<Book> findById(String id);

    Mono<Book> findByName(String name);

    Mono<Book> save(Mono<Book> book);

}
