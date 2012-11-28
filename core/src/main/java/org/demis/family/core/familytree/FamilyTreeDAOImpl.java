package org.demis.family.core.familytree;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FamilyTreeDAOImpl implements FamilyTreeDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public FamilyTree findByPrimaryKey(String id) {
        return (FamilyTree) sessionFactory.getCurrentSession().get(FamilyTree.class, id);
    }
}
