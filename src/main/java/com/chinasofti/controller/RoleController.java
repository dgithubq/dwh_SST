package com.chinasofti.controller;

import com.chinasofti.entity.Role;
import com.chinasofti.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.selectAllRoleService();
        mv.addObject("roles",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public ModelAndView add(Role role){
        ModelAndView modelAndView = new ModelAndView();
        roleService.add(role);
        modelAndView.setViewName("redirect:/role/list");
        return modelAndView;
    }

    @RequestMapping("/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        roleService.deleteSur(id);
        roleService.delete(id);
        modelAndView.setViewName("redirect:/role/list");
        return modelAndView;
    }
}
