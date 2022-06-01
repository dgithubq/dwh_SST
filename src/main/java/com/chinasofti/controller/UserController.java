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
import java.util.ArrayList;
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

    //添加用户
    @RequestMapping("/save.do")
    public ModelAndView add(User user,String roleId){//页面那边传进来长字符串
        ModelAndView modelAndView = new ModelAndView();
        //先添加user
        userService.add(user);
        //把长字符串转数组
        List<Integer> roleIds = new ArrayList<>();
        String[] split = roleId.split(",");
        //分别拿到值
        for (String s : split) {
            roleIds.add(Integer.parseInt(s));
        }
        userService.addUserByRole(user,roleIds);
        modelAndView.setViewName("redirect:/user/list");
        return modelAndView;
    }

    //删除用户
    @RequestMapping("/delete.do")
    public ModelAndView deleteUser(Integer uid){
        ModelAndView modelAndView = new ModelAndView();
        userService.deleteUserByRole(uid);
        userService.deleteUser(uid);
        modelAndView.setViewName("redirect:/user/list");
        return modelAndView;
    }
}
