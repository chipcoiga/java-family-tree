package org.demis.family.core.user;

import org.demis.family.core.familytree.FamilyTreeEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserEntity findByPrimaryKey(String id) {
        return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
        return criteria.list();

    }

    public String save(UserEntity userEntity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        userEntity.setModificationDate(now);

        if (userEntity.getCreationDate() == null) {
            userEntity.setCreationDate(now);
        }

        return (String) sessionFactory.getCurrentSession().save(userEntity);
    }

    public void update(UserEntity userEntity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        userEntity.setModificationDate(now);

        if (userEntity.getCreationDate() == null) {
            userEntity.setCreationDate(now);
        }

        sessionFactory.getCurrentSession().merge(userEntity);
    }

    public void delete(String id) {
        UserEntity userEntity = findByPrimaryKey(id);
        sessionFactory.getCurrentSession().delete(userEntity);
    }

}
