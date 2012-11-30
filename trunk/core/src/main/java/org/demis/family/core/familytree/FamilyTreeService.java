package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("familyTreeService")
public class FamilyTreeService {

    private static final Logger logger = Logger.getLogger(FamilyTreeService.class);

    @Autowired
    private FamilyTreeDAO dao;

    @Transactional
    public FamilyTreeEntity getById(String id) {
        return dao.findByPrimaryKey(id);
    }

    @Transactional
    public List<FamilyTreeEntity> getAll() {
        return dao.findAll();
    }

    @Transactional
    public void update(FamilyTreeEntity familyTreeEntity) {
        dao.update(familyTreeEntity);
    }

    @Transactional
    public void create(FamilyTreeEntity familyTreeEntity) {
        dao.save(familyTreeEntity);
    }

    @Transactional
    public void delete(FamilyTreeEntity familyTreeEntity) {
        dao.delete(familyTreeEntity.getId());
    }

    @Transactional
    public void delete(String id) {
        dao.delete(id);
    }
}
