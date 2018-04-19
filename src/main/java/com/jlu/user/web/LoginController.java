package com.jlu.user.web;

import com.jlu.common.web.AbstractController;
import com.jlu.user.model.Role;
import com.jlu.user.model.User;
import com.jlu.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/user")
public class LoginController extends AbstractController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        User activeUser = userService.getUserByNameAndPwd(user.getUsername(), user.getPassword());
        if (activeUser == null) {
            model.addAttribute("wrongMsg", "用户名或者密码错误");
            return "login";
        } else if (Role.ADMIN.equals(activeUser.getRole())) {
            return "adminMain";
        } else {
            return "userMain";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
