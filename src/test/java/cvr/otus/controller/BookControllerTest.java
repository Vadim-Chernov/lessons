package cvr.otus.controller;

import cvr.otus.BookFakeFilling;
import cvr.otus.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest extends BookFakeFilling {


    @Autowired
    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        dropAll();
        fillAll();

    }

    @Test
    public void bookCreateTest() {
        Book book = new Book("Книга1");

        webTestClient.post().uri("/books")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(book), Book.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.name").isEqualTo("Книга1");
    }

    @Test
    public void testGetAllBooks() {
        webTestClient.get().uri("/books")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Book.class);
    }

    @Test
    public void testGetById() {
        Book book = operations.insert(new Book("Hello, World!"));

        webTestClient.get()
                .uri("/books/{id}", Collections.singletonMap("id", book.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());
    }

    @Test
    public void testUpdateBook() {
        Book book = operations.save(new Book("Initial"));

        Book newBook = new Book("Updated");

        webTestClient.put()
                .uri("/books/{id}", Collections.singletonMap("id", book.getId()))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(newBook), Book.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.name").isEqualTo("Updated");
    }

    @Test
    public void testDeleteBook() {
        Book book = operations.insert(new Book("To be deleted"));

        webTestClient.delete()
                .uri("/books/{id}", Collections.singletonMap("id",  book.getId()))
                .exchange()
                .expectStatus().isOk();
    }
}