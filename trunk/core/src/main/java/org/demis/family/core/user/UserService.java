package org.demis.family.core.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO dao;

    public UserEntity getById(String id) {
        return dao.findByPrimaryKey(id);
    }

    public List<UserEntity> getAll() {
        return dao.findAll();
    }

    public void update(UserEntity userEntity) {
        dao.update(userEntity);
    }

    public void create(UserEntity userEntity) {
        dao.save(userEntity);
    }

    public void delete(UserEntity userEntity) {
        dao.delete(userEntity.getId());
    }

    public void delete(String id) {
        dao.delete(id);
    }
}
