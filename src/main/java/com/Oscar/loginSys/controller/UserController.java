package com.Oscar.loginSys.controller;


import com.Oscar.loginSys.Service.UserService;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loginSys")
public class UserController {

    // service layer setup
    @Autowired
    private UserService userservice;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    // From Controller, applying service layer method
    @GetMapping("/all")
    public List<User> getAll(){
        return userservice.getall();
    }

    @GetMapping("/update")
    public List<User> update(){
        User newppl = new User();
        newppl.setEmail("Oscar@gmail.com");
        newppl.setPassword("22222");

        userservice.insert(newppl);
        return userservice.getall();
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
