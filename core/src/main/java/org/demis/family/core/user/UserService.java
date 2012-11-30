package org.demis.family.core.user;

import org.apache.log4j.Logger;
import org.demis.family.core.familytree.FamilyTreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDAO dao;

    @Transactional
    public UserEntity getById(String id) {
        return dao.findByPrimaryKey(id);
    }

    @Transactional
    public List<UserEntity> getAll() {
        return dao.findAll();
    }

    @Transactional
    public void update(UserEntity userEntity) {
        dao.update(userEntity);
    }

    @Transactional
    public void create(UserEntity userEntity) {
        dao.save(userEntity);
    }

    @Transactional
    public void delete(UserEntity userEntity) {
        dao.delete(userEntity.getId());
    }

    @Transactional
    public void delete(String id) {
        dao.delete(id);
    }
}
