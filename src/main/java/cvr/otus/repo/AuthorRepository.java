package cvr.otus.repo;

import cvr.otus.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author,String> {

    Author getById(String id);

    @SuppressWarnings("unchecked")
    Author save(Author author);

    List<Author> findAll();
}
