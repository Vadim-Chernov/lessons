package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final NamedParameterJdbcOperations operations;

    public BookRepositoryImpl(NamedParameterJdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public Book save(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        operations.update("insert into book (id,name) values(HIBERNATE_SEQUENCE.nextval, :name)", params);
        return getByName(name);
    }

    @Override
    public List<Book> findAll() {
        List<Book> authors = operations.query("select * from book", new BookMapper());
        return authors;
    }

    @Override
    public Book getByName(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        Book book = operations.queryForObject("select * from book where name = :name", params, new BookMapper());
        return book;
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Book book = operations.queryForObject("select * from book where id = :id", params, new BookMapper());
        return book;
    }

    @Override
    public Book addAuthor(Long book_id, Long author_id) {
        return null;
    }

    @Override
    public Book addGenre(Long book_id, Long genre_id) {
        return null;
    }

    @Override
    public Book removeAuthor(Long book_id, Long author_id) {
        return null;
    }

    @Override
    public Book removeGenre(Long book_id, Long genre_id) {
        return null;
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Book(id,name);
        }
    }
}
