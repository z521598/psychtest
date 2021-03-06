package com.jlu.user.web;

import com.jlu.common.permission.annotations.PermissionAdmin;
import com.jlu.common.permission.annotations.PermissionPass;
import com.jlu.common.web.AbstractController;
import com.jlu.common.web.ResponseBean;
import com.jlu.user.model.Role;
import com.jlu.user.model.User;
import com.jlu.user.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    IUserService userService;

    @PermissionPass
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(User user) {
        user.setRole(Role.USER);
        user.setDisable(false);
        userService.saveOrUpdateUser(user);
        return "forward:/user/login";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        user.setRole(Role.USER);
        user.setDisable(false);
        userService.saveOrUpdateUser(user);
        return "";
    }

    @PermissionPass
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

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ModelAndView all(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserByName(username);
        modelAndView.addObject("user", user);
        System.out.println(user);
        modelAndView.setViewName("user/one");
        return modelAndView;
    }


    @PermissionAdmin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user/users");
        return modelAndView;
    }

    @PermissionAdmin
    @RequestMapping(value = "/disable", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean disable(String username, @RequestParam(defaultValue = "true") Boolean disable) {
        User user = userService.getUserByName(username);
        user.setDisable(disable);
        userService.saveOrUpdateUser(user);
        return ResponseBean.TRUE;
    }

    @PermissionAdmin
    @RequestMapping(value = "/admin/updatePwd",method = RequestMethod.POST)
    public ModelAndView updatePwd(Integer userId,String password) {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUserById(userId);
        user.setPassword(password);
        userService.saveOrUpdateUser(user);
        mav.setViewName("login");
        mav.addObject("wrongMsg", "修改密码成功，请重新登录");
        return mav;
    }



}
