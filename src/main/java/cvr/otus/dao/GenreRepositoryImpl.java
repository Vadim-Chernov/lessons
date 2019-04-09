package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository

public class GenreRepositoryImpl implements GenreRepository {
    private final NamedParameterJdbcOperations operations;

    public GenreRepositoryImpl(NamedParameterJdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public Genre save(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        operations.update("insert into genre (id,name) values(HIBERNATE_SEQUENCE.nextval, :name)", params);
        return getByName(name);
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = operations.query("select * from genre", new GenreMapper());
        return genres;
    }

    @Override
    public Genre getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Genre genre = operations.queryForObject("select * from genre where id = :id", params, new GenreMapper());
        return genre;
    }

    @Override
    public Genre getByName(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name );
        Genre genre = operations.queryForObject("select * from genre where name = :name", params, new GenreMapper());
        return genre;
    }
    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int i) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Genre(id,name);
        }
    }

}
