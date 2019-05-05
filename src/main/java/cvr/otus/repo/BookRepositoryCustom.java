package cvr.otus.repo;

import cvr.otus.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepositoryCustom {

    Book addGenre(String bookId, String genreId);

    Book addAuthor(String bookId, String authorId);

    Book removeGenre(String bookId, String genreId);

    Book removeAuthor(String bookId, String authorId);
}
