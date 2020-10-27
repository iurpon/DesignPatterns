package ru.trandefil.hw5.orm.second;


import ru.trandefil.hw5.IDbEntity;

import java.util.Set;

/**
 * ISecondOrmContext.
 *
 * @author Ilya_Sukhachev
 */
public interface ISecondOrmContext {

    Set<IDbEntity> getUsers();

    Set<IDbEntity> getUserInfo();

}
