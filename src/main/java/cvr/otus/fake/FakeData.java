package cvr.otus.fake;

import cvr.otus.domain.Author;
import cvr.otus.domain.Book;
import cvr.otus.domain.Genre;
import cvr.otus.repo.AuthorRepository;
import cvr.otus.repo.BookRepository;
import cvr.otus.repo.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class FakeData {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public FakeData(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
//        init();
    }

    public void init() {
        Author author1 = authorRepository.add("Ivanovich");
        Author author2 = authorRepository.add("Petrovich");
        Author author3 = authorRepository.add("Sidorovich");
        Author author4 = authorRepository.add("Stepanovich");

        Genre genre1 = genreRepository.add("Сказки");
        Genre genre2 = genreRepository.add("Поэзия");
        Genre genre3 = genreRepository.add("Наука");

        Book book1 = bookRepository.add("Анатомия");
        book1.setComment("Очень полезная книга");
        book1 = bookRepository.addAuthor(book1.getId(), author1.getId());
        book1 = bookRepository.addAuthor(book1.getId(), author2.getId());
        book1 = bookRepository.addGenre(book1.getId(), genre3.getId());

        Book book2 = bookRepository.add("Про бабу Ягу");
        book2.setComment("НЕ очень полезная книга");
        book2 = bookRepository.addAuthor(book2.getId(), author3.getId());
        book2 = bookRepository.addGenre(book2.getId(), genre1.getId());

        Book book3 = bookRepository.add("Час быка");
        book3.setComment("Очень НЕ полезная книга");
        book3 = bookRepository.addAuthor(book3.getId(), author3.getId());
        book3 = bookRepository.addAuthor(book3.getId(), author4.getId());
        book3 = bookRepository.addGenre(book3.getId(), genre1.getId());
        book3 = bookRepository.addGenre(book3.getId(), genre3.getId());
    }
}
