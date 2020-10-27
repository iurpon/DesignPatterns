package ru.trandefil.hw5.orm.first;


import ru.trandefil.hw5.IDbEntity;

/**
 * IFirstOrm.
 *
 * @author Ilya_Sukhachev
 */
public interface IFirstOrm<T extends IDbEntity> {

    void create(T entity);

    T read(int id);

    void update(T entity);

    void delete(T entity);
}
