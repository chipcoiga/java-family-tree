package org.demis.family.core.familytree;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class FamilyTreeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public FamilyTreeEntity findByPrimaryKey(String id) {
        return (FamilyTreeEntity) sessionFactory.getCurrentSession().get(FamilyTreeEntity.class, id);
    }

    public List<FamilyTreeEntity> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FamilyTreeEntity.class);
        return criteria.list();

    }

    public String save(FamilyTreeEntity familyTreeEntity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        familyTreeEntity.setModificationDate(now);

        if (familyTreeEntity.getCreationDate() == null) {
            familyTreeEntity.setCreationDate(now);
        }

        return (String) sessionFactory.getCurrentSession().save(familyTreeEntity);
    }

    public void update(FamilyTreeEntity familyTreeEntity) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        familyTreeEntity.setModificationDate(now);

        if (familyTreeEntity.getCreationDate() == null) {
            familyTreeEntity.setCreationDate(now);
        }

        sessionFactory.getCurrentSession().merge(familyTreeEntity);
    }

    public void delete(String id) {
        FamilyTreeEntity familyTreeEntity = findByPrimaryKey(id);
        sessionFactory.getCurrentSession().delete(familyTreeEntity);
    }

}
