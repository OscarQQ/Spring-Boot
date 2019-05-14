package com.Oscar.loginSys.controller;


import com.Oscar.loginSys.Service.UserService;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/loginSys")
public class UserController {

    // service layer setup
    @Autowired
    private UserService userservice;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    // From Controller, applying service layer method
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll(){ return userservice.getall(); }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public List<User> update(){
        User newppl = new User();
        newppl.setEmail("Oscar@gmail.com");
        newppl.setPassword("22222");

        userservice.insert(newppl);
        return userservice.getall();
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }


//    @PostMapping("/signup")
//    public User signup(){
//
//    }

//    activiti 6.0
//    ajax
//    bootstrap
//    aop    qiemian tongzhi
//    filter  request response
//    file upload
//    interceptor


}
