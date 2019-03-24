package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Book.all", query = "select a from Book a"),
        @NamedQuery(name = "Book.ByName", query = "select a from Book a where a.name=:name")
})

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SQ")
    @SequenceGenerator(name = "BOOK_SQ", sequenceName = "book_sq")
    private int id;

    private String name;

    private String comment;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    private List<Author> authors = new ArrayList<>();

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", comment=" + comment +
                ", genres=" + genres +
                ", authors=" + authors +
                '}';
    }
}
