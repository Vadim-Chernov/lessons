package cvr.otus.dao;

import cvr.otus.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private final NamedParameterJdbcOperations operations;

    public AuthorRepositoryImpl(NamedParameterJdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public Author save(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        operations.update("insert into author (id,name) values(HIBERNATE_SEQUENCE.nextval, :name)", params);
        return getByName(name);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = operations.query("select * from author", new AuthorMapper());
        return authors;
    }

    @Override
    public Author getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Author author = operations.queryForObject("select * from author where id = :id", params, new AuthorMapper());
        return author;
    }

    @Override
    public Author getByName(String name){
        Map<String, Object> params = Collections.singletonMap("name", name);
        Author author = operations.queryForObject("select * from author where name = :name", params, new AuthorMapper());
        return author;
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Author(id,name);
        }
    }
}
