package com.jlu.user.web;

import com.jlu.common.web.AbstractController;
import com.jlu.user.model.User;
import com.jlu.user.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(User user) {
        System.out.println(user);
        userService.saveOrUpdateUser(user);
        return "forward:/user/login";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Boolean query(String username) {
        User user = userService.getUserByName(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}
