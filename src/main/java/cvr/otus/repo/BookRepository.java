package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,List> ,BookRepositoryCustom{

    Book getById(Long id);

    @SuppressWarnings("unchecked")
    Book save(Book book);

    List<Book> findAll();

//    Book addGenre(Long book, Long genre);
//
//    Book addAuthor(Long book, Long author);
//
//    Book removeGenre(Long book, Long genre);
//
//    Book removeAuthor(Long book, Long author);
}
