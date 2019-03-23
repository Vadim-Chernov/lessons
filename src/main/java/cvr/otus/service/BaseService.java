package cvr.otus.service;

import java.util.List;

public interface BaseService<T> {
    T add(String name);

    List<T> getAll();

    T get(int id);
}
