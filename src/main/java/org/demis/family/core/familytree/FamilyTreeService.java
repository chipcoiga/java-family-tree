package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.familytree.FamilyTree;
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
        return null;
    }
}
