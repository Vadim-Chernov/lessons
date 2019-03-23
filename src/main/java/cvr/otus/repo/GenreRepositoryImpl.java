package cvr.otus.repo;

import cvr.otus.domain.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class GenreRepositoryImpl implements GenreRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getById(int id) {
        return em.find(Genre.class, id);
    }

    @Override
    @Transactional
    public Genre add(String name) {
        return em.merge(new Genre(name));
    }

    @Override
    public List<Genre> getAll() {
        final Query selectAll = em.createNamedQuery("Genre.all");
        return selectAll.getResultList();
    }
}
