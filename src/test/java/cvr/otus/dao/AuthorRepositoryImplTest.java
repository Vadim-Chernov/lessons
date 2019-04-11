package cvr.otus.dao;


import cvr.otus.domain.Author;
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
@Import(AuthorRepositoryImpl.class)
public class AuthorRepositoryImplTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void getById() {
        Author author = authorRepository.createNew("Петров");
        Author byId = authorRepository.getById(author.getId());
        assertEquals(author.getId(),byId.getId());
    }

    @Test
    public void add() {
        Author author = authorRepository.createNew("Иванов");
        Long id = author.getId();
        Author byId = authorRepository.getById(id);
        assertEquals("Иванов",byId.getName());

    }

    @Test
    public void getAll() {
        List<Author> all = authorRepository.findAll();
        assertNotNull(all);
    }
}
