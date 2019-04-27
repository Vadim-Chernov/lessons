//package cvr.otus.repo;
//
//import cvr.otus.domain.Genre;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@DisplayName("GenreRepositoryImplTest интерграционный тест")
//@RunWith(SpringRunner.class)//(SpringJUnit4ClassRunner.class)// SpringRunner.class
//@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
//
//public class GenreRepositoryImplTest {
//
//    @Autowired
//    private GenreRepository genreRepository;
//
//    @Test
//    @DisplayName("getById")
//    public void getById() {
//        Genre genre = genreRepository.save(new Genre("123"));
//        Genre byId = genreRepository.getById(genre.getId());
//        assertEquals(genre.getId(), byId.getId());
//    }
//
//    @Test
//    public void add() {
//        Genre genre = genreRepository.save(new Genre("123"));
//        Genre byId = genreRepository.getById(genre.getId());
//        assertEquals("123", byId.getName());
//
//    }
//
//    @Test
//    public void getAll() {
//        List<Genre> all = genreRepository.findAll();
//        assertNotNull(all);
//    }
//}