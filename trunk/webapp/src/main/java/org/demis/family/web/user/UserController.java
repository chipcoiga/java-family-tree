package org.demis.family.web.user;


import org.apache.log4j.Logger;
import org.demis.family.core.user.UserEntity;
import org.demis.family.core.user.UserService;
import org.demis.family.web.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    public UserController() {
        // no op
    }

    @RequestMapping(value = "/api/users/{userid}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public UserExposed getUser(@PathVariable("userid") String id) throws ResourceNotFound {
        UserEntity UserEntity;

        try {
            UserEntity = service.getById(id);
        } catch (Exception e) {
            throw new ResourceNotFound("Resource users/" + id + " not found", e);
        }

        if (UserEntity == null) {
            throw new ResourceNotFound("Resource users/" + id + " not found");
        }

        return converter.convert(UserEntity);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<UserExposed> getUsers() throws ResourceNotFound {
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

    @RequestMapping(value = "/api/users", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public void createUser(@RequestBody UserExposed exposed, HttpServletRequest request) {
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

    @RequestMapping(value = "/api/users/{userid}", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @Transactional
    public void updateUser(@PathVariable("userid") String id, @RequestBody UserExposed exposed, HttpServletRequest request) throws ResourceNotFound {
        // verify the resource exist
        UserEntity UserEntity;
        try {
            UserEntity = service.getById(id);
        } catch (Exception e) {
            throw new ResourceNotFound("Resource users/" + id + " not found", e);
        }
        // Update the resource
        UserEntity = converter.convertExposed(exposed);
        UserEntity.setId(id);
        service.update(UserEntity);
    }

    @RequestMapping(value = "/api/users/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteUser(@PathVariable("userid") String id) {
        service.delete(id);
    }
}
