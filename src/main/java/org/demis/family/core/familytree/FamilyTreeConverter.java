package org.demis.family.core.familytree;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyTreeConverter {

    public FamilyTree convertExposed(FamilyTreeExposed exposed) {
        return null;
    }

    public FamilyTreeExposed convert(FamilyTree bean) {
        FamilyTreeExposed exposed = new FamilyTreeExposed();
        exposed.setFamilyTreeId(bean.getFamilyTreeId());
        return exposed;
    }

    public List<FamilyTree> convertExposed(List<FamilyTreeExposed> exposed) {
        return null;
    }

    public List<FamilyTreeExposed> convert(List<FamilyTree> beans) {
        return null;
    }
}
