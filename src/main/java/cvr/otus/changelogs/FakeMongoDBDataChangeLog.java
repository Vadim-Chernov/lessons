package cvr.otus.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.service.BookService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@ChangeLog(order = "001" )
public class FakeMongoDBDataChangeLog {
    private static final String MY_NAME ="chernov.vr@gmail.com";
    private Author[] authors = new Author[3];
    private Genre[] genres = new Genre[3];
    private Book[] books = new Book[3];


    @ChangeSet(order = "000", id = "dropDB", author = MY_NAME, runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "faceAuthors", author = MY_NAME, runAlways = true)
    public void faceAuthors(MongoTemplate template) {
        authors[0] = new Author("Ivanov");
        authors[1] = new Author("Petrov");
        authors[2] = new Author("Sidorov");
        authors[0] = template.save(authors[0]);
        authors[1] = template.save(authors[1]);
        authors[2] = template.save(authors[2]);
    }
    @ChangeSet(order = "002", id = "faceGenres", author = MY_NAME, runAlways = true)
    public void faceGenres(MongoTemplate template) {
        genres[0] = new Genre("Детектив");
        genres[1] = new Genre("Анекдот");
        genres[2] = new Genre("Публицистика");
        genres[0] = template.save(genres[0]);
        genres[1] = template.save(genres[1]);
        genres[2] = template.save(genres[2]);
    }

    @ChangeSet(order = "003", id = "faceBooks", author = MY_NAME, runAlways = true)
    public void faceBooks(MongoTemplate template) {
        books[0] = new Book("M-412","Как ремонтировать машину Москвич",authors,genres);
        books[1] = new Book("Анекдот","Про Петьку",new Author[] {authors[0],authors[1]},new Genre[] {genres[1]} );
        books[2] = new Book("Публицистика");
        books[0] = template.save(books[0]);
        books[1] = template.save(books[1]);
        books[2] = template.save(books[2]);
    }

}
