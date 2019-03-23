package cvr.otus.repo;

import cvr.otus.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    @Transactional
    public Author add(String name) {
        return em.merge(new Author(name));
    }

    @Override
//    @Transactional
    public List<Author> getAll() {
        final Query selectAll = em.createNamedQuery("Author.all");
        return selectAll.getResultList();
    }
}
