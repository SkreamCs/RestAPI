package abdul.restApi.repository;

import com.google.protobuf.Internal;

import java.util.List;

public interface GenericRepository<ID, E> {
    E save(E e);
    E update(E e);
    void delete(ID id);
    E getById(ID id);
    List<E> getAll();
}
