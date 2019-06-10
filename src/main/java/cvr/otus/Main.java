package cvr.otus;

import cvr.otus.changelogs.FakeMongoDBDataChangeLog;
import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.AuthorRepository;
import cvr.otus.repo.BookRepository;
import cvr.otus.repo.GenreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);

        FakeMongoDBDataChangeLog fakeMongo = new FakeMongoDBDataChangeLog(context);
        fakeMongo.fillDB();
    }
}
