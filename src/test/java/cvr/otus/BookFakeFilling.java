package cvr.otus;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class BookFakeFilling {

    @Autowired
    protected MongoOperations operations;

    protected Author author1;
    protected Author author2;
    protected Author author3;
    protected Genre genre1;
    protected Genre genre2;
    protected Book book1;
    protected Book book2;
    protected Book book3;

    protected void dropAll() {
        operations.dropCollection(Book.class);
        operations.dropCollection(Author.class);
        operations.dropCollection(Genre.class);

    }

    protected void fillAll() {
        author1 = operations.insert(new Author("author1"));
        author2 = operations.insert(new Author("author2"));
        author3 = operations.insert(new Author("author3"));

        genre1 = operations.insert(new Genre("genre1"));
        genre2 = operations.insert(new Genre("genre2"));


        book1 = new Book("Book1", "Comment1", new Author[]{author1, author2, author3}, new Genre[0]);
        book2 = new Book("Book2", "", new Author[0], new Genre[]{genre1, genre2});
        book3 = new Book("Book3", "Comment3", new Author[]{author3}, new Genre[0]);

        book1 = operations.insert(book1);
        book2 = operations.insert(book2);
        book3 = operations.insert(book3);

        operations.findAll(Book.class).forEach(System.out::println);

    }
}
