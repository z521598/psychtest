package com.jlu.user.dao;

import com.jlu.common.db.dao.IBaseDao;
import com.jlu.user.model.Role;
import com.jlu.user.model.User;

/**
 * Created by langshiquan on 17/3/10.
 */
public interface IUserDao extends IBaseDao<User> {

    User get(String username, Role role);
    User get(String username);

}
