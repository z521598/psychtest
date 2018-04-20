package com.jlu.common.web;

import com.jlu.common.permission.annotations.PermissionPass;
import com.jlu.user.model.Role;
import com.jlu.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/8/4.
 */

@ApiIgnore
@Controller
public class HomeController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute(User.CURRENT_USER_NAME);
        if (user == null) {
            return "login";
        }
        if (Role.ADMIN.equals(((User) user).getRole())) {
            return "main/admin";
        } else {
            return "main/user";
        }

    }

    @PermissionPass
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exitLogin(HttpServletResponse response, HttpServletRequest request) {
        request.getSession().removeAttribute(User.CURRENT_USER_NAME);
        return "login";
    }

}
