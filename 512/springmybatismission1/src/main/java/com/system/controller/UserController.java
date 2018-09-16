package com.system.controller;

import com.system.model.LoginCommand;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author AllenYang
 * @date 18-9-9 下午11:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String Loginin(){

        return "login";
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
        if (loginCommand.getUserName()!=null||loginCommand.getPassword()!=null) {
            System.out.println(loginCommand.getUserName()+"+"+loginCommand.getPassword());
            boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),
                    loginCommand.getPassword());
            if (!isValidUser) {
                return new ModelAndView("login", "error", "用户名或密码错误！");
            } else {
                return new ModelAndView("main");
            }
        }else {
            return new ModelAndView("regUser");
        }
    }
}
