package cvr.otus.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

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
