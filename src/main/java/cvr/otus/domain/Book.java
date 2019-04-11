package cvr.otus.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {

    private Long id;
    private String name;
    private String comment;
    private List<Genre> genres = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name=name;
    }

    public Book(Long id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
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
