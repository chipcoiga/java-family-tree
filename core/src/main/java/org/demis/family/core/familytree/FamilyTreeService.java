package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("familyTreeService")
public class FamilyTreeService {

    private static final Logger logger = Logger.getLogger(FamilyTreeService.class);

    @Autowired
    private FamilyTreeDAO dao;

    public FamilyTreeEntity getById(String id) {
        return dao.findByPrimaryKey(id);
    }

    public List<FamilyTreeEntity> getAll() {
        return dao.findAll();
    }

    public void update(FamilyTreeEntity familyTreeEntity) {
        dao.update(familyTreeEntity);
    }

    public void create(FamilyTreeEntity familyTreeEntity) {
        dao.save(familyTreeEntity);
    }

    public void delete(FamilyTreeEntity familyTreeEntity) {
        dao.delete(familyTreeEntity.getId());
    }

    public void delete(String id) {
        dao.delete(id);
    }
}
