package repository;

import java.util.List;

public interface CRUD<E> {
    List<E> getAll();

    int save(E e);

    int delete(int id);

    List<E> search(String name);
}
