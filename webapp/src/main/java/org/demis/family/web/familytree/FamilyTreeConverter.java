package org.demis.family.web.familytree;

import org.demis.family.core.familytree.FamilyTreeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyTreeConverter {

    public FamilyTreeEntity convertExposed(FamilyTreeExposed exposed) {
        FamilyTreeEntity bean = new FamilyTreeEntity();
        return bean;
    }

    public FamilyTreeExposed convert(FamilyTreeEntity bean) {
        FamilyTreeExposed exposed = new FamilyTreeExposed();
        exposed.setFamilyTreeId(bean.getId());
        if (bean.getCreationDate() != null)
            exposed.setCreationDate(bean.getCreationDate().getTime());
        if (bean.getModificationDate() != null)
            exposed.setModificationDate(bean.getModificationDate().getTime());
        exposed.setURI(FamilyTreeExposed.URI_BASE + bean.getId());
        return exposed;
    }

    public List<FamilyTreeEntity> convertExposed(List<FamilyTreeExposed> exposed) {
        ArrayList<FamilyTreeEntity> result = new ArrayList<FamilyTreeEntity>(exposed.size());

        for (FamilyTreeExposed anExposed: exposed) {
            result.add(convertExposed(anExposed));
        }
        return result;
    }

    public List<FamilyTreeExposed> convert(List<FamilyTreeEntity> beans) {
        ArrayList<FamilyTreeExposed> result = new ArrayList<FamilyTreeExposed>(beans.size());

        for (FamilyTreeEntity bean: beans) {
            result.add(convert(bean));
        }
        return result;
    }
}
