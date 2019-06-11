package cvr.otus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {

    @Id
    private String id;

    private String name;

    private String comment;

    @DBRef
    private List<Genre> genres = new ArrayList<>();

    @DBRef
    private List<Author> authors = new ArrayList<>();

//    public void deleteAuthor(String authorId) {
//        for (Author author : authors)
//            if (authorId.equals(author.getId()))
//                authors.remove(author);
//    }

    public Book copy(Book b) {
        if (b.getId() == null)
            return new Book();
        Book book = new Book();
        book.setId(b.getId());
        book.setName(b.getName());
        book.setComment(b.getComment());
        book.setAuthors(b.getAuthors());
        book.setGenres(b.getGenres());
        return book;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String comment,  Author[] authors, Genre[] genres) {
        this.name = name;
        this.comment = comment;
        this.authors = Arrays.asList(authors);
        this.genres = Arrays.asList(genres);
    }
}
