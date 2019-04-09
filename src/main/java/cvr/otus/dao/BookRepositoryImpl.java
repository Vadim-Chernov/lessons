package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final NamedParameterJdbcOperations operations;

    public BookRepositoryImpl(NamedParameterJdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public Book createNew(String name) {
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
        return getById(book.getId());
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        Book book = operations.queryForObject("select * from book where id = :id", params, new BookMapper());
        String sql = "SELECT a.id,a.name FROM BOOK_AUTHORS ba,AUTHOR a WHERE ba.AUTHORS_ID = a.ID AND ba.BOOK_ID  = :id";
        List<Author> authors = operations.query(sql, params, new AuthorMapper());
        book.setAuthors(authors);
        sql = "SELECT a.id,a.name FROM BOOK_GENRES ba,GENRE a WHERE ba.GENRES_ID = a.ID AND ba.BOOK_ID  = :id";
        List<Genre> genres = operations.query(sql, params, new GenreMapper());
        book.setGenres(genres);
        return book;
    }

    @Override
    public Book addAuthor(Long book_id, Long author_id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book_id);
        params.put("authors_id", author_id);
        operations.update("insert into book_authors(book_id,authors_id) values(:book_id,:authors_id)", params);
        return getById(book_id);
    }

    @Override
    public Book addGenre(Long book_id, Long genre_id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book_id);
        params.put("genres_id", genre_id);
        operations.update("insert into book_genres(book_id,genres_id) values(:book_id,:genres_id)", params);
        return getById(book_id);
    }

    @Override
    public Book removeAuthor(Long book_id, Long author_id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book_id);
        params.put("authors_id", author_id);
        operations.update("delete from book_authors where  book_id= :book_id and authors_id= :authors_id)", params);
        return getById(book_id);
    }

    @Override
    public Book removeGenre(Long book_id, Long genres_id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book_id);
        params.put("genres_id", genres_id);
        operations.update("delete from book_authors where  book_id= :book_id and genres_id= :genres_id)", params);
        return getById(book_id);
    }

}

class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        return new Book(id, name);
    }
}
