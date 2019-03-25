package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
//import javax.transaction.Transactional;
//import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book add(String name) {
        Book book = new Book(name);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    public List<Book> getAll() {
        final Query selectAll = em.createNamedQuery("Book.all");
        return selectAll.getResultList();
    }

    @Override
    public Book addGenre(int book_id, int genre_id) {
        Book book = getById(book_id);
        Genre genre = genreRepository.getById(genre_id);
        book.getGenres().add(genre);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    public Book addAuthor(int book_id, int author_id) {
        Book book = getById(book_id);
        Author author = authorRepository.getById(author_id);
        book.getAuthors().add(author);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    public Book removeGenre(int book_id, int genre_id) {
        Book book = getById(book_id);
        Genre genre = genreRepository.getById(genre_id);
        book.getGenres().remove(genre);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    public Book removeAuthor(int book_id, int author_id) {
        Book book = getById(book_id);
        Author author = authorRepository.getById(author_id);
        book.getAuthors().remove(author);
        Book merged = em.merge(book);
        return merged;
    }
}
