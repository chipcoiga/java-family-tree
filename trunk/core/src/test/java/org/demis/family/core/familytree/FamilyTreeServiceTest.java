package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.individual.IndividualEntity;
import org.demis.family.core.individual.IndividualService;
import org.demis.family.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:hibernate-config.xml"})
public class FamilyTreeServiceTest extends AbstractTestNGSpringContextTests {

    private static final Logger logger = Logger.getLogger(FamilyTreeServiceTest.class);

    @Autowired
    private FamilyTreeService familyTreeService;

    @Autowired
    private IndividualService individualService;

    @Autowired
    private UserService userService;

    @Test
    public void createFamilyTree() {
        FamilyTreeEntity familyTree = new FamilyTreeEntity();
        familyTreeService.create(familyTree);


        Assert.assertNotNull(familyTree.getId());
    }

    @Test
    public void addIndividual() {
        FamilyTreeEntity familyTree = new FamilyTreeEntity();
        IndividualEntity individual = new IndividualEntity();
        familyTree.addIndividual(individual);
        userService.create(individual);
        familyTreeService.create(familyTree);
        Assert.assertNotNull(familyTree.getId());
    }
}
