package cvr.otus.repo;

import cvr.otus.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepositoryCustom {

    Book addGenre(Long book, Long genre);

    Book addAuthor(Long book, Long author);

    Book removeGenre(Long book, Long genre);

    Book removeAuthor(Long book, Long author);
}
