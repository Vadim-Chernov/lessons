package cvr.otus.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import cvr.otus.BookFakeFilling;
import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest

public class BookRepositoryTest extends BookFakeFilling {
    @Autowired
    protected BookRepository repository;


    public void setUp() {
        dropAll();
        fillAll();
    }


    @Test
    public void updateBookShouldWork() {
        dropAll();
        findAll();
        Book book = repository.findById(book1.getId()).block();
        book.setName("Updated");
        book.setComment("Updated");
        book.getAuthors().remove(author1);
        Mono<Book> saved = repository.save(book);
        Mono<Book> found = repository.findByName("Updated");
        Book b = saved.block();
        Book b1 = found.block();

        assertTrue(b.getId().equals(b1.getId()));
        assertTrue(b.getName().equals(b1.getName()));
        assertTrue(b.getComment().equals(b1.getComment()));

        for (int i = 0; i < 2; i++) {
            assertTrue(b.getAuthors().get(i).getName().equals(b1.getAuthors().get(i).getName()));
        }
    }


    @Test
    public void saveNewBookShouldWork() {
        dropAll();
        findAll();
        Book book = new Book("Book4", "Comment4", new Author[]{author1, author2}, new Genre[]{genre1, genre2});
        Mono<Book> saved = repository.save(book);
        Mono<Book> found = repository.findByName("Book4");
        Book b = saved.block();
        Book b1 = found.block();

        assertTrue(b.getId().equals(b1.getId()));
        assertTrue(b.getName().equals(b1.getName()));
        assertTrue(b.getComment().equals(b1.getComment()));

        for (int i = 0; i < 2; i++) {
            assertTrue(b.getAuthors().get(i).getName().equals(b1.getAuthors().get(i).getName()));
            assertTrue(b.getGenres().get(i).getName().equals(b1.getGenres().get(i).getName()));
        }
    }

    @Test
    public void findByNameShouldWork() {
        setUp();

        Mono<Book> first = Mono.first(repository.findById(book1.getId()));

        StepVerifier.create(first)
                .expectNextMatches(results -> {
                    assertThat(results.getName()).isEqualTo("Book1");
                    assertThat(results.getId()).isNotBlank();
                    return true;
                })
                .verifyComplete();
    }

    @Test
    public void findByIdShouldWork() {
        setUp();
        Mono<Book> image = repository.findById(book1.getId());

        StepVerifier.create(image)
                .expectNextMatches(results -> {
                    assertThat(results.getName()).isEqualTo("Book1");
                    assertThat(results.getId()).isNotBlank();
                    return true;
                })
                .verifyComplete();
    }


    @Test
    public void shouldSetIdOnSave() {
        setUp();

        Mono<Book> bookMono = repository.save(new Book("Bill"));

        StepVerifier
                .create(bookMono)
                .assertNext(book -> assertNotNull(book.getId()))
                .expectComplete()
                .verify();
    }


    @Test
    public void findAll() {
        setUp();
        Flux<Book> all = Flux.fromIterable(repository.findAll().toIterable());
        StepVerifier.create(all)
                .recordWith(ArrayList::new)
                .expectNextCount(3)
                .consumeRecordedWith(results -> {
                    assertThat(results)
                            .extracting(Book::getName)
                            .contains(
                                    "Book1",
                                    "Book2",
                                    "Book3");

                })
                .verifyComplete();

    }

}