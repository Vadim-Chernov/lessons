package cvr.otus.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@Data
@NamedQueries({
        @NamedQuery(name = "Author.all", query = "select a from Author a"),
        @NamedQuery(name = "Author.ByName", query = "select a from Author a where a.name=:name")
})
public class Author extends BaseObject {
    public Author(String name) {
        super(name);
    }

    public Author() {
        super();
    }

}
