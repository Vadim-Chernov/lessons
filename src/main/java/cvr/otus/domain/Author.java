package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Author.all", query = "select a from Author a"),
        @NamedQuery(name = "Author.ByName", query = "select a from Author a where a.name=:name")
})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SQ")
    @SequenceGenerator(name = "AUTHOR_SQ", sequenceName = "AUTHOR_SQ")
    private int id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

}
