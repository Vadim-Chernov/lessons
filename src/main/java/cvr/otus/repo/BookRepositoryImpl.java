package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    @Transactional
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
    @Transactional
    public Book addGenre(Book book, Genre genre) {
        book.getGenres().add(genre);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    @Transactional
    public Book addAuthor(Book book, Author author) {
        book.getAuthors().add(author);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    @Transactional
    public Book removeGenre(Book book, Genre genre) {
        book.getGenres().remove(genre);
        Book merged = em.merge(book);
        return merged;
    }

    @Override
    @Transactional
    public Book removeAuthor(Book book, Author author) {
        book.getAuthors().remove(author);
        Book merged = em.merge(book);
        return merged;
    }
}
