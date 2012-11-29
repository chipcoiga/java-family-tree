package org.demis.family.web.familytree;

import org.demis.family.core.familytree.FamilyTree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyTreeConverter {

    public FamilyTree convertExposed(FamilyTreeExposed exposed) {
        return null;
    }

    public FamilyTreeExposed convert(FamilyTree bean) {
        FamilyTreeExposed exposed = new FamilyTreeExposed();
        exposed.setFamilyTreeId(bean.getFamilyTreeId());
        exposed.setURI(FamilyTreeExposed.URI_BASE + bean.getFamilyTreeId());
        return exposed;
    }

    public List<FamilyTree> convertExposed(List<FamilyTreeExposed> exposed) {
        return null;
    }

    public List<FamilyTreeExposed> convert(List<FamilyTree> beans) {
        ArrayList<FamilyTreeExposed> result = new ArrayList<FamilyTreeExposed>(beans.size());

        for (FamilyTree bean: beans) {
            result.add(convert(bean));
        }
        return result;
    }
}
