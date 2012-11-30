package org.demis.family.core;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GenericDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public E findByPrimaryKey(String id) {
        return (E) sessionFactory.getCurrentSession().get(E.class, id);
    }

    public List<E> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(E.class);
        return criteria.list();

    }

    public String save(E entity) {
        return (String) sessionFactory.getCurrentSession().save(entity);
    }

    public void update(E entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(String id) {
        E entity = findByPrimaryKey(id);
        sessionFactory.getCurrentSession().delete(entity);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
