package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

    @Override
    public String toString(){
        return name;
    }
}
