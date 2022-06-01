package com.chinasofti.controller;

import com.chinasofti.entity.User;
import com.chinasofti.service.UserService;
import com.mysql.cj.xdevapi.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    //登陆界面
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        User user = userService.login(username, password);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
