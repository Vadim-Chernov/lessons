package cvr.otus;

import cvr.otus.domain.Book;
import cvr.otus.fakedata.FakeData;
import cvr.otus.repository.AuthorRepository;
import cvr.otus.repository.BookRepository;
import cvr.otus.repository.GenreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);

        FakeData fakeMongo = new FakeData(
                context.getBean(BookRepository.class),
                context.getBean(GenreRepository.class),
                context.getBean(AuthorRepository.class)
        );

        fakeMongo.fillDB();
    }


    //Недоделано, навернное пока не надо
    @Bean
    public RouterFunction<ServerResponse> composedRoutes(BookRepository repository) {
        BookHandler handler = new BookHandler(repository);

        RouterFunction<ServerResponse> route = route()
                .GET("/func/book", accept(APPLICATION_JSON_UTF8), handler::list)
                .GET("/func/book/{id}", accept(APPLICATION_JSON),
                        req -> repository.findById(req.pathVariable("id"))
                                .flatMap(p -> ok().contentType(APPLICATION_JSON_UTF8).body(fromObject(p))))
                .GET("/func/book/del/{id}", accept(APPLICATION_JSON),
                        req -> repository.deleteById(req.pathVariable("id"))
                                .flatMap(p -> ok().contentType(APPLICATION_JSON_UTF8).body(fromObject(p))))
                .build();

        return route;
    }

    static class BookHandler {

        private BookRepository repository;

        BookHandler(BookRepository repository) {
            this.repository = repository;
        }

        Mono<ServerResponse> list(ServerRequest request) {
            return ok().contentType(APPLICATION_JSON_UTF8).body(repository.findAll(), Book.class);
        }

        public Mono<Book> createBooks(@Valid @RequestBody Book book) {
            return repository.save(book);
        }
    }
}
