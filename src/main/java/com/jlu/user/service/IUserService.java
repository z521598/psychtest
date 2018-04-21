package com.jlu.user.service;

import com.jlu.user.model.User;

import java.util.List;

/**
 * Created by langshiquan on 17/3/10.
 */
public interface IUserService {

    void saveOrUpdateUser(User user);

    /**
     * 通过用户名和密码获得用户
     *
     * @param username
     * @return
     */
    User getUserByNameAndPwd(String username, String password);

    Boolean idAdmin(String username);

    User getUserByName(String username);

    List<User> findAll();

    User getUserById(Integer userId);
}
