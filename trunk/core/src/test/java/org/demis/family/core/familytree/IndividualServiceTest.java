package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.individual.IndividualEntity;
import org.demis.family.core.individual.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:hibernate-config.xml"})
public class IndividualServiceTest extends AbstractTestNGSpringContextTests {

    private static final Logger logger = Logger.getLogger(IndividualServiceTest.class);

    @Autowired
    private IndividualService service;

    @Test
    public void createIndividual() {
        IndividualEntity individual = new IndividualEntity();
        individual.setFirstName("Stéphane");
        individual.setLastName("Kermabon");
        individual.setSosaCode("I001");
        service.create(individual);
        Assert.assertNotNull(individual.getId());
        Assert.assertNotNull(individual.getCreationDate());
        Assert.assertNotNull(individual.getModificationDate());
        Assert.assertEquals(individual.getFirstName(), "Stéphane", "Bad first name");
        Assert.assertEquals(individual.getLastName(), "Kermabon", "Bad last name");
        Assert.assertEquals(individual.getSosaCode(), "I001", "Bad sosa name");
    }

}
