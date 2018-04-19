package com.jlu.user.service.impl;

import com.jlu.common.db.sqlcondition.ConditionAndSet;
import com.jlu.user.model.Role;
import com.jlu.user.dao.IUserDao;
import com.jlu.user.model.User;
import com.jlu.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by langshiquan on 17/3/10.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void saveOrUpdateUser(User user) {
        userDao.saveOrUpdate(user);
    }

    /**
     * 通过用户获得密码
     * @param username
     * @return
     */
    public User getUserByNameAndPwd(String username,String password) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("username", username);
        conditionAndSet.put("password", password);
        List<User> users = userDao.findByProperties(conditionAndSet);
        if (users != null && users.size() != 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public Boolean idAdmin(String username) {
        User user = userDao.get(username, Role.ADMIN);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUserByName(String username) {
        return userDao.get(username);
    }
}
