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
    public Book addGenre(String book_id, String genre_id) {
        Book book = bookRepository.getById(book_id);
        Genre genre = genreRepository.getById(genre_id);
        book.getGenres().add(genre);
        return bookRepository.save(book);
    }

    @Override
    public Book addAuthor(String book_id, String author_id) {
        Book book = bookRepository.getById(book_id);
        Author author = authorRepository.getById(author_id);
        book.getAuthors().add(author);
        return bookRepository.save(book);
    }

    @Override
    public Book removeGenre(String book_id, String genre_id) {
        Book book = bookRepository.getById(book_id);
        Genre genre = genreRepository.getById(genre_id);
        book.getGenres().remove(genre);
        return bookRepository.save(book);
    }

    @Override
    public Book removeAuthor(String book_id, String author_id) {
        Book book = bookRepository.getById(book_id);
        Author author = authorRepository.getById(author_id);
        book.getAuthors().remove(author);
        return bookRepository.save(book);
    }


}
