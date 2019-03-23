package cvr.otus.repo;

import cvr.otus.domain.Genre;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("GenreRepositoryImplTest интерграционный тест")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class GenreRepositoryImplTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("getById")
    public void getById() {
        Genre genre = genreRepository.add("123");
        Genre byId = genreRepository.getById(genre.getId());
        assertEquals(genre.getId(), byId.getId());
    }

    @Test
    public void add() {
        Genre genre = genreRepository.add("123");
        Genre byId = genreRepository.getById(genre.getId());
        assertEquals("123", byId.getName());

    }

    @Test
    public void getAll() {
        List<Genre> all = genreRepository.getAll();
        assertNotNull(all);
    }
}