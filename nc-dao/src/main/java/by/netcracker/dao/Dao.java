package by.netcracker.dao;

/**
 * Created by ilya on 4/8/15.
 */

import by.netcracker.dao.exceptions.DaoException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for DaoImpl class.
 * <a href="https://www.ibm.com/developerworks/ru/library/j-genericdao/">Don't repeat dao</a>
 * @see by.netcracker.dao.DaoImpl
 * @author Hromenkov Ilya
 * @version 1.0
 */
public interface Dao<T, PK extends Serializable> {

    T get(PK id) throws DaoException;

    List<T> getAll() throws DaoException;

    PK add(T object) throws DaoException;

    void update(T object) throws DaoException;

    void delete(T object) throws DaoException;

    Query getQuery(String hql) throws DaoException;

}
