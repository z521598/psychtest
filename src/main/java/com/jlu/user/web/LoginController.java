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

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/user")
public class LoginController extends AbstractController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) {
        User activeUser = userService.getUserByNameAndPwd(user.getUsername(), user.getPassword());
        if (activeUser == null) {
            model.addAttribute("wrongMsg", "用户名或者密码错误");
            return "login";
        }
        request.getSession().setAttribute(User.CURRENT_USER_NAME, activeUser);
        if (Role.ADMIN.equals(activeUser.getRole())) {
            return "main/admin";
        } else {
            return "main/user";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
