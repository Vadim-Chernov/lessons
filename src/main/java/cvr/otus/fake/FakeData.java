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
        Author author1 = authorRepository.add("Ivanov");
        Author author2 = authorRepository.add("Petrov");
        Author author3 = authorRepository.add("Sidorov");
        Author author4 = authorRepository.add("Stepanov");

        Genre genre1 = genreRepository.add("Детектив");
        Genre genre2 = genreRepository.add("Фантастика");
        Genre genre3 = genreRepository.add("Анекдоты");

        Book book1 = bookRepository.add("Смертельное убийство");
        book1.setComment("Очень интересная книга");
        book1 = bookRepository.addAuthor(book1, author1);
        book1 = bookRepository.addAuthor(book1, author2);
        book1 = bookRepository.addGenre(book1, genre1);

        Book book2 = bookRepository.add("Про Чапаева");
        book2.setComment("НЕ очень интересная книга");
        book2 = bookRepository.addAuthor(book2, author3);
        book2 = bookRepository.addGenre(book2, genre3);

        Book book3 = bookRepository.add("Час быка");
        book3.setComment("Очень НЕ интересная книга");
        book3 = bookRepository.addAuthor(book3, author3);
        book3 = bookRepository.addAuthor(book3, author4);
        book3 = bookRepository.addGenre(book3, genre2);
        book3 = bookRepository.addGenre(book3, genre3);
    }
}
