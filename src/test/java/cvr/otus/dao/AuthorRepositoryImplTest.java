package cvr.otus.dao;


import cvr.otus.Main;
import cvr.otus.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


//@DisplayName("AuthorRepositoryImplTest интерграционный тест")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
@JdbcTest
//@ConditionalOnMissingClass
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class AuthorRepositoryImplTest {

    @Autowired
    private AuthorRepository authorRepository;




    @Test
//    @DisplayName("getById")
    public void getById() {
        Author author = authorRepository.createNew("Петров");
        Author byId = authorRepository.getById(author.getId());
        assertEquals(author.getId(),byId.getId());
    }

    @Test
//    @DisplayName("add")
    public void add() {
        Author author = authorRepository.createNew("Иванов");
        Long id = author.getId();
        Author byId = authorRepository.getById(id);
        assertEquals("Иванов",byId.getName());

    }

    @Test
//    @DisplayName("add")
    public void getAll() {
        List<Author> all = authorRepository.findAll();
        assertNotNull(all);
    }
}
