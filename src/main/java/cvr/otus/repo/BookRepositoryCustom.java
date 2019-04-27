package cvr.otus.repo;

import cvr.otus.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepositoryCustom {

    Book addGenre(String book, String genre);

    Book addAuthor(String book, String author);

    Book removeGenre(String book, String genre);

    Book removeAuthor(String book, String author);
}
