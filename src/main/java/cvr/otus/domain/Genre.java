package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
    @Override
    public String toString(){
        return name;
    }

}
