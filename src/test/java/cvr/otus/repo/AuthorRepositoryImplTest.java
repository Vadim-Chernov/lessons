//package cvr.otus.repo;
//
//
//import cvr.otus.domain.Author;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DisplayName("AuthorRepositoryImplTest интерграционный тест")
//@RunWith(SpringJUnit4ClassRunner.class)// SpringRunner.class
//@SpringBootTest
//public class AuthorRepositoryImplTest {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @org.junit.Test
//    @DisplayName("getById")
//    public void getById() {
//        Author author = authorRepository.add("Петров");
//        Author byId = authorRepository.getById(author.getId());
//        assertEquals(author.getId(),byId.getId());
//    }
//
//    @org.junit.Test
//    @DisplayName("add")
//    public void add() {
//        Author author = authorRepository.add("Иванов");
//        int id = author.getId();
//        Author byId = authorRepository.getById(id);
//        assertEquals("Иванов",byId.getName());
//
//    }
//
//    @org.junit.Test
//    @DisplayName("add")
//    public void getAll() {
//        List<Author> all = authorRepository.getAll();
//        assertNotNull(all);
//    }
//}
