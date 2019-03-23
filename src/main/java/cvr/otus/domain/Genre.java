package cvr.otus.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@Data
@NamedQueries({
        @NamedQuery(name = "Genre.all", query = "select g from Genre g"),
        @NamedQuery(name = "Genre.byName", query = "select g from Genre g where g.name = :name"),
})
public class Genre extends BaseObject {
    public Genre(String name) {
        super(name);
    }

    public Genre() {
        super();
    }

}
