package by.netcracker.dao;

import by.netcracker.dao.exceptions.DaoErrorCode;
import by.netcracker.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ilya on 4/8/15.
 */


//@Repository("dao")
public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {
    private static Logger log = Logger.getLogger(DaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    public DaoImpl(Class<T> type) {
        this.type = type;
    }

    public DaoImpl() {
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id) throws DaoException {
        try {
            log.info("Getting object with id: " + id);
            T entity = (T) getSession().get(type, id);
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_000);
        }
    }

    @Override
    public List getAll() throws DaoException {
        try {
            log.info("Getting list of object");
            List<T> list = getSession().createCriteria(type).list();
            return list;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_001);
        }
    }

    @Override
    public PK add(T object) throws DaoException {
        try {
            PK id = (PK) getSession().save(object);
            log.info("Adding object with id: " + id);
            return id;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_002);
        }
    }

    @Override
    public void update(T object) throws DaoException {
        try {
            log.info("Updating object");
            getSession().saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_003);
        }
    }

    @Override
    public void delete(T object) throws DaoException {
        try {
            log.info("Deleting object");
            getSession().delete(object);
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_004);
        }
    }

    @Override
    public Query getQuery(String hql) throws DaoException {
        try {
            log.info("Getting hql query");
            Query query = getSession().createQuery(hql);
            return query;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.NC_DAO_005);
        }
    }
}
