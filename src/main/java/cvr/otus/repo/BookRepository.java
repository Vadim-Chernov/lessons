package cvr.otus.repo;

import com.mongodb.lang.Nullable;
import cvr.otus.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookRepository extends ReactiveMongoRepository<Book, String>, BookRepositoryCustom {

    Mono<Book> getById(String id);

    Mono<Book> save(Book book);


}
