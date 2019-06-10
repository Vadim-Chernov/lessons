package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class BookRepositoryImpl implements BookRepositoryCustom {

    private  BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    //    @Autowired
    public BookRepositoryImpl( AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book addGenre(String bookId, String genreId) {
        Genre genre = genreRepository.getById(genreId).block();
        Book book = bookRepository.getById(bookId).block();
        book.getGenres().add(genre);
        return bookRepository.save(book).block();
    }

    @Override
    public Book addAuthor(String bookId, String authorId) {
        Book book = bookRepository.getById(bookId).block();
        Author author = authorRepository.getById(authorId).block();
        book.getAuthors().add(author);
        return bookRepository.save(book).block();
    }

    @Override
    public Book removeGenre(String bookId, String genreId) {
        Book book = bookRepository.getById(bookId).block();
        Genre genre = genreRepository.getById(genreId).block();
        book.getGenres().remove(genre);
        return bookRepository.save(book).block();
    }

    @Override
    public Book removeAuthor(String bookId, String authorId) {
        Book book = bookRepository.getById(bookId).block();
        Author author = authorRepository.getById(authorId).block();
        book.getAuthors().remove(author);
        return bookRepository.save(book).block();
    }


}
