package org.demis.family.web.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.demis.family.core.familytree.FamilyTreeService;
import org.demis.family.web.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.util.ObjectUtils.nullSafeToString;

@Controller
class FamilyTreeController {

    private static final Logger logger = Logger.getLogger(FamilyTreeController.class);

    @Autowired
    private FamilyTreeService service;

    @Autowired
    private FamilyTreeConverter converter;

    public FamilyTreeController() {
        // no op
    }

    @RequestMapping(value = "/api/familytrees/{familyTreeId}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public FamilyTreeExposed getFamilyTree(@PathVariable("familyTreeId") String familyTreeId) throws ResourceNotFound {
        FamilyTreeEntity familyTreeEntity;

        try {
            familyTreeEntity = service.getById(familyTreeId);
        } catch (Exception e) {
            throw new ResourceNotFound("Resource familytrees/" + familyTreeId + " not found", e);
        }

        if (familyTreeEntity == null) {
            throw new ResourceNotFound("Resource familytrees/" + familyTreeId + " not found");
        }

        return converter.convert(familyTreeEntity);
    }

    @RequestMapping(value = "/api/familytrees", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<FamilyTreeExposed> getFamilyTrees() throws ResourceNotFound {
        try {
            return converter.convert(service.getAll());
        }
        catch (Exception e) {
            logger.error("Error when get family trees", e);
            return null;
        }
        finally {
            logger.debug("get family trees end");
        }
    }

    @RequestMapping(value = "/api/familytrees", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public void createFamilyTree(@RequestBody FamilyTreeExposed exposed, HttpServletRequest request) {
        try {
            service.create(converter.convertExposed(exposed));
        }
        catch (Exception e) {
            logger.error("Error when create a family tree", e);
        }
        finally {
            logger.debug("create family tree end");
        }
    }

    @RequestMapping(value = "/api/familytrees/{familyTreeId}", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @Transactional
    public void updateFamilyTree(@PathVariable("familyTreeId") String familyTreeId, @RequestBody FamilyTreeExposed exposed, HttpServletRequest request) throws ResourceNotFound {
        // verify the resource exist
        FamilyTreeEntity familyTreeEntity;
        try {
            familyTreeEntity = service.getById(familyTreeId);
        } catch (Exception e) {
            throw new ResourceNotFound("Resource familytrees/" + familyTreeId + " not found", e);
        }
        // Update the resource
        familyTreeEntity = converter.convertExposed(exposed);
        familyTreeEntity.setId(familyTreeId);
        service.update(familyTreeEntity);
    }

    @RequestMapping(value = "/api/familytrees/{familyTreeId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteFamilyTree(@PathVariable("familyTreeId") String familyTreeId) {
        service.delete(familyTreeId);
    }
}