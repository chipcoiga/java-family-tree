package org.demis.family.core.familytree;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamilyTreeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public FamilyTree findByPrimaryKey(String id) {
        return (FamilyTree) sessionFactory.getCurrentSession().get(FamilyTree.class, id);
    }

    public List<FamilyTree> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FamilyTree.class);
        return criteria.list();

    }

    public int save(FamilyTree familyTree) {
        return (Integer) sessionFactory.getCurrentSession().save(familyTree);
    }

    public void update(FamilyTree familyTree) {
        sessionFactory.getCurrentSession().merge(familyTree);
    }

    public void delete(String id) {
        FamilyTree familyTree = findByPrimaryKey(id);
        sessionFactory.getCurrentSession().delete(familyTree);
    }

}
