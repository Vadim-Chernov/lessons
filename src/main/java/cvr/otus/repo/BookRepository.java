package cvr.otus.repo;

import com.mongodb.lang.Nullable;
import cvr.otus.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {

    Book getById(String id);

    @SuppressWarnings("unchecked")
    Book save(Book book);

//    List<Book> findAll();

}
