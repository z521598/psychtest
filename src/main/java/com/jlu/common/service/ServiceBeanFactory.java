package com.jlu.common.service;

import com.jlu.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/19.
 */
@Service
public class ServiceBeanFactory {
    private static IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        ServiceBeanFactory.userService = userService;
    }


    public static IUserService getUserService() {
        return userService;
    }
}
