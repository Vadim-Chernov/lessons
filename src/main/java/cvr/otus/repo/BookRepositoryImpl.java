package cvr.otus.repo;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;

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
        Book book = bookRepository.getById(bookId);
        Genre genre = genreRepository.getById(genreId);
        book.getGenres().add(genre);
        return bookRepository.save(book);
    }

    @Override
    public Book addAuthor(String bookId, String authorId) {
        Book book = bookRepository.getById(bookId);
        Author author = authorRepository.getById(authorId);
        book.getAuthors().add(author);
        return bookRepository.save(book);
    }

    @Override
    public Book removeGenre(String bookId, String genreId) {
        Book book = bookRepository.getById(bookId);
        Genre genre = genreRepository.getById(genreId);
        book.getGenres().remove(genre);
        return bookRepository.save(book);
    }

    @Override
    public Book removeAuthor(String bookId, String authorId) {
        Book book = bookRepository.getById(bookId);
        Author author = authorRepository.getById(authorId);
        book.getAuthors().remove(author);
        return bookRepository.save(book);
    }


}
