package org.demis.family.core;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class GenericDAO<E extends AbstractEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    public E findByPrimaryKey(String id) {
        return (E) sessionFactory.getCurrentSession().get(getEntityName(), id);
    }

    public List<E> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityName());
        return criteria.list();

    }

    public String save(E entity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        entity.setModificationDate(now);

        if (entity.getCreationDate() == null) {
            entity.setCreationDate(now);
        }
        return (String) sessionFactory.getCurrentSession().save(entity);
    }

    public void update(E entity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        entity.setModificationDate(now);

        if (entity.getCreationDate() == null) {
            entity.setCreationDate(now);
        }
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

    public abstract String getEntityName();
}
