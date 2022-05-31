package com.chinasofti.controller;

import com.chinasofti.entity.User;
import com.chinasofti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public ModelAndView selectUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.selectUsers();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
