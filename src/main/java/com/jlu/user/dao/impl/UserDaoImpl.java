package com.jlu.user.dao.impl;

import com.jlu.common.db.dao.AbstractBaseDao;
import com.jlu.common.db.sqlcondition.ConditionAndSet;
import com.jlu.common.utils.CollUtils;
import com.jlu.user.model.Role;
import com.jlu.user.dao.IUserDao;
import com.jlu.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by langshiquan on 17/3/10.
 *
 * 用户信息管理dao实体类
 */
@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements IUserDao {
    @Override
    public User get(String username, Role role) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("username", username);
        conditionAndSet.put("role", role);
        List<User> users = findByProperties(conditionAndSet);
        return CollUtils.isEmpty(users) ? null : users.get(0);
    }

    @Override
    public User get(String username) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("username", username);
        List<User> users = findByProperties(conditionAndSet);
        return CollUtils.isEmpty(users) ? null : users.get(0);
    }

}
