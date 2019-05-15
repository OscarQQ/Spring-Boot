package com.Oscar.loginSys.controller;


import com.Oscar.loginSys.Service.UserService;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public List<User> update(){
        User newppl = new User();
        newppl.setEmail("Oscar@gmail.com");
        newppl.setPassword("22222");

        userservice.insert(newppl);
        return userservice.getall();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Map<String,Object> map) {
        map.put("user",new User());
        return "signup";
    }

    @RequestMapping(value ="/s", method = RequestMethod.POST)
    public String save(User user){
        userservice.insert(user);
        return "redirect:/";
    }

}
