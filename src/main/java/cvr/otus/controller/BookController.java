package cvr.otus.controller;

import cvr.otus.domain.Book;
import cvr.otus.exception.ObjectNotFoundException;
import cvr.otus.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Mono<Book> createBooks(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public Mono<ResponseEntity<Book>> getBookById(@PathVariable(value = "id") String bookId) {
        return bookRepository.findById(bookId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/books/{id}")
    public Mono<ResponseEntity<Book>> updateBook(@PathVariable(value = "id") String bookId,
                                                 @Valid @RequestBody Book book) {
        return bookRepository.findById(bookId)
                .flatMap(existingBook -> {
                    existingBook.setName(book.getName());
                    existingBook.setComment(book.getComment());
                    existingBook.setAuthors(book.getAuthors());
                    existingBook.setGenres(book.getGenres());
                    return bookRepository.save(existingBook).defaultIfEmpty(new Book());
                })
                .map(updateBook -> new ResponseEntity<>(updateBook, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                ;
    }

    @DeleteMapping("/books/{id}")
    public Mono<ResponseEntity<Void>> deleteBook(@PathVariable(value = "id") String bookId) {

        return bookRepository.findById(bookId)
                .flatMap(existingBook ->
                        bookRepository.delete(existingBook)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/stream/books", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> streamAllBooks() {
        return bookRepository.findAll();
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleBookNotFoundException(ObjectNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

}