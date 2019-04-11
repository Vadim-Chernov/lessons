package cvr.otus.dao;

import cvr.otus.domain.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@JdbcTest
@Import(GenreRepositoryImpl.class)
public class GenreRepositoryImplTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void getById() {
        Genre genre = genreRepository.createNew("123");
        Genre byId = genreRepository.getById(genre.getId());
        assertEquals(genre.getId(), byId.getId());
    }

    @Test
    public void add() {
        Genre genre = genreRepository.createNew("123");
        Genre byId = genreRepository.getById(genre.getId());
        assertEquals("123", byId.getName());

    }

    @Test
    public void getAll() {
        List<Genre> all = genreRepository.findAll();
        assertNotNull(all);
    }
}