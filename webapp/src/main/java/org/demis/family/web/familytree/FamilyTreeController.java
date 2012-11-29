package org.demis.family.web.familytree;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.demis.family.core.familytree.FamilyTree;
import org.demis.family.core.familytree.FamilyTreeService;
import org.demis.family.web.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.util.ObjectUtils.isEmpty;
import static org.springframework.util.ObjectUtils.nullSafeToString;

@Controller
public class FamilyTreeController {

    private static final Logger logger = Logger.getLogger(FamilyTreeController.class);

    @Autowired
    private FamilyTreeService service;

    @Autowired
    private FamilyTreeConverter converter;

    @RequestMapping(value = "/api/familytrees/{familyTreeId}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public FamilyTreeExposed getFamilyTree(@PathVariable("familyTreeId") String familyTreeId) throws ResourceNotFound {
        FamilyTree familyTree = null;

        try {
            familyTree = service.getById(familyTreeId);
        } catch (Exception e) {
            throw new ResourceNotFound("Resource familytrees/" + familyTreeId + " not found", e);
        }

        if (familyTree == null) {
            throw new ResourceNotFound("Resource familytrees/" + familyTreeId + " not found");
        }

        return converter.convert(familyTree);
    }

}
