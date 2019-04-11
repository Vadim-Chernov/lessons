package cvr.otus.dao;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final NamedParameterJdbcOperations operations;
    private static final String SQL =
            "select b.ID,b.NAME,b.COMMENT, ba.AUTHORS_ID, a.name AUTHOR, bg.GENRES_ID, g.NAME GENRE\n" +
                    "    from  BOOK b\n" +
                    "    left join BOOK_AUTHORS ba on   b.ID = ba.BOOK_ID\n" +
                    "    left join AUTHOR a on ba.AUTHORS_ID = a.ID\n" +
                    "    left join BOOK_GENRES  bg on   b.ID = bg.BOOK_ID\n" +
                    "    left join GENRE  g on bg.GENRES_ID = g.ID\n";
    private static final String WHERE_ID = " where b.id = :id";

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
    public Book getByName(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        Book book = operations.queryForObject("select * from book where name = :name", params, new BookMapper());
        return getById(book.getId());
    }

    @Override
    public List<Book> findAll() {
        List<Map<String, Object>> list = operations.queryForList(SQL,Collections.EMPTY_MAP);
        List<Book> books = generateBooks(list);
        return books;
    }

    private List<Book> generateBooks(List<Map<String, Object>> list) {
        Map<Long, Book> bookMap = new HashMap<>(10);
        Map<Long, Genre> genreMap = new HashMap<>(50);
        Map<Long, Author> authorMap = new HashMap<>(50);
        Book book = null;

        for (Map<String, Object> map : list) {
            Author author = null;
            Genre genre = null;
            Long book_id = (Long) map.get("ID");
            if (bookMap.get(book_id) == null) {
                String name = (String) map.get("NAME");
                String comment = (String) map.get("COMMENT");
                book = new Book(book_id, name, comment);
                bookMap.put(book_id,book);
            }
            Long authors_id = (Long) map.get("AUTHORS_ID");
            if (authors_id != null) {
                if (authorMap.get(authors_id) == null) {
                    String name = (String) map.get("AUTHOR");
                    author = new Author(authors_id, name);
                    book.getAuthors().add(author);
                    authorMap.put(authors_id, author);
                }
            }
            Long genres_id = (Long) map.get("GENRES_ID");
            if (genres_id != null) {
                if (genreMap.get(genres_id) == null) {
                    String name = (String) map.get("GENRE");
                    genre = new Genre(genres_id, name);
                    book.getGenres().add(genre);
                    genreMap.put(genres_id, genre);
                }
            }
        }
//        Collection<Book> values = ;
        Collection<Book> values = bookMap.values();
        List<Book> books = new ArrayList<>(values);
        return books;
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        List<Map<String, Object>> list = operations.queryForList(SQL + WHERE_ID, params);
        return generateBooks(list).get(0);
    }

    @Override
    public Book addAuthor(Book book, Author author) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book.getId());
        params.put("authors_id", author.getId());
        operations.update("insert into book_authors(book_id,authors_id) values(:book_id,:authors_id)", params);
        return getById(book.getId());
    }


    @Override
    public Book addGenre(Book book, Genre genre) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book.getId());
        params.put("genres_id", genre.getId());
        operations.update("insert into book_genres(book_id,genres_id) values(:book_id,:genres_id)", params);
        return getById(book.getId());
    }

    @Override
    public Book removeAuthor(Book book, Author author) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book.getId());
        params.put("authors_id", author.getId());
        operations.update("delete from book_authors where  book_id= :book_id and authors_id= :authors_id", params);
        return getById(book.getId());
    }

    @Override
    public Book removeGenre(Book book, Genre genres) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("book_id", book.getId());
        params.put("genres_id", genres.getId());
        operations.update("delete from book_genres where  book_id= :book_id and genres_id= :genres_id", params);
        return getById(book.getId());
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
