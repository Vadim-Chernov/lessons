package cvr.otus.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseObject implements IBaseObject {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public BaseObject(String name) {
        this.name = name;
    }

    public BaseObject() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {id=" + id + ", name='" + name + "'}";
    }
}
