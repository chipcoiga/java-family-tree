package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.user.UserEntity;
import org.demis.family.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(locations={"classpath:hibernate-config.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    private static final Logger logger = Logger.getLogger(UserServiceTest.class);

    @Autowired
    private UserService service;


    @Test
    public void createUser() {
        UserEntity user = new UserEntity();
        user.setEmail("demis27@gmail.com");
        service.create(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void getUser() {
        UserEntity user = service.getById("aze");
        Assert.assertEquals(user.getEmail(), "aze@email.com");
    }
}
