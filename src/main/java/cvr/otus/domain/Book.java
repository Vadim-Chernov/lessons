package cvr.otus.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Book.all", query = "select a from Book a"),
        @NamedQuery(name = "Book.ByName", query = "select a from Book a where a.name=:name")
})

public class Book extends BaseObject {
    private String comment;
    @ManyToMany
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    public Book(String name) {
        super(name);
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
