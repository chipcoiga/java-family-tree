package org.demis.family.core.familytree;

import org.apache.log4j.Logger;
import org.demis.family.core.user.UserEntity;
import org.demis.family.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
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
        user.setFirstName("Stéphane");
        user.setLastName("Kermabon");
        service.create(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getCreationDate());
        Assert.assertNotNull(user.getModificationDate());
        Assert.assertEquals(user.getEmail(), "demis27@gmail.com", "Bad email");
        Assert.assertEquals(user.getFirstName(), "Stéphane", "Bad first name");
        Assert.assertEquals(user.getLastName(), "Kermabon", "Bad last name");
    }

    @Test
    public void getUser() {
        UserEntity user = createUserEntity();
        UserEntity foundUser = service.getById(user.getId());
        Assert.assertEquals(foundUser.getEmail(), user.getEmail());
    }

    @Test
    public void deleteUser() {
        UserEntity user = createUserEntity();
        UserEntity foundUser = service.getById(user.getId());
        Assert.assertEquals(foundUser.getEmail(), user.getEmail());
        service.delete(user.getId());
        foundUser = service.getById(user.getId());
        Assert.assertNull(foundUser);
    }

    @Test
    public void updateUser() {
        UserEntity user = createUserEntity();
        UserEntity foundUser = service.getById(user.getId());
        foundUser.setEmail("demis28@gmail.com");
        service.update(foundUser);
        foundUser = service.getById(user.getId());
        Assert.assertEquals(foundUser.getEmail(), "demis28@gmail.com");
    }

    private UserEntity createUserEntity() {
        UserEntity user = new UserEntity();
        user.setEmail("demis27@gmail.com");
        user.setFirstName("Stéphane");
        user.setLastName("Kermabon");
        service.create(user);
        return user;
    }
}
