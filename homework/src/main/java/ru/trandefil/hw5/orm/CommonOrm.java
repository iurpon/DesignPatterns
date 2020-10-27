package ru.trandefil.hw5.orm;

import java.util.Set;

public interface CommonOrm<T> {

    void create(T entity);

    T read(Long id);

    void update(T entity);

    void delete(T entity);

    Set<T> getAll();

    Set<T> getAllInfo();

}
