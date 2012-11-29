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

    public FamilyTree getById(String id) {
        return dao.findByPrimaryKey(id);
    }

    public List<FamilyTree> getAll() {
        return dao.findAll();
    }

    public void update(FamilyTree familyTree) {
        dao.update(familyTree);
    }

    public void save(FamilyTree familyTree) {
        dao.save(familyTree);
    }

    public void delete(FamilyTree familyTree) {
        dao.delete(familyTree.getFamilyTreeId());
    }

    public void delete(String familyTreeId) {
        dao.delete(familyTreeId);
    }
}
