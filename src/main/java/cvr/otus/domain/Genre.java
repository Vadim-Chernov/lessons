package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "Genre.all", query = "select g from Genre g"),
        @NamedQuery(name = "Genre.byName", query = "select g from Genre g where g.name = :name"),
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_SQ")
    @SequenceGenerator(name = "GENRE_SQ", sequenceName = "genre_sq")
    private int id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

}
