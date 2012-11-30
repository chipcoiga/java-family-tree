package org.demis.family.web.user;

import org.demis.family.core.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter {

    public UserEntity convertExposed(UserExposed exposed) {
        UserEntity bean = new UserEntity();
        bean.setEmail(exposed.getEmail());
        bean.setFirstName(exposed.getFirstName());
        bean.setLastName(exposed.getLastName());
        return bean;
    }

    public UserExposed convert(UserEntity bean) {
        UserExposed exposed = new UserExposed();
        exposed.setId(bean.getId());
        if (bean.getCreationDate() != null)
            exposed.setCreationDate(bean.getCreationDate().getTime());
        if (bean.getModificationDate() != null)
            exposed.setModificationDate(bean.getModificationDate().getTime());
        exposed.setEmail(bean.getEmail());
        exposed.setFirstName(bean.getFirstName());
        exposed.setLastName(bean.getLastName());
        exposed.setURI(UserExposed.URI_BASE + bean.getId());
        return exposed;
    }

    public List<UserEntity> convertExposed(List<UserExposed> exposed) {
        ArrayList<UserEntity> result = new ArrayList<UserEntity>(exposed.size());

        for (UserExposed anExposed: exposed) {
            result.add(convertExposed(anExposed));
        }
        return result;
    }

    public List<UserExposed> convert(List<UserEntity> beans) {
        ArrayList<UserExposed> result = new ArrayList<UserExposed>(beans.size());

        for (UserEntity bean: beans) {
            result.add(convert(bean));
        }
        return result;
    }
}
