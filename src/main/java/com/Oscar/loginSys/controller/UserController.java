package com.Oscar.loginSys.controller;


import com.Oscar.loginSys.Service.UserService;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    //the root, will direct to index.html under templates folder
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //A unchangeable built-in user info
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public List<User> update(){
        User newppl = new User();
        newppl.setEmail("Oscar@gmail.com");
        newppl.setPassword("22222");

        userservice.insert(newppl);
        return userservice.getall();
    }

    // direct to sign up page, submit info there
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Map<String,Object> map) {
        map.put("user",new User());
        return "signup";
    }

    @RequestMapping(value ="/s", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userservice.insert(user);
        //direct to controller mapping and eventually go to index.html
        return "redirect:/";
    }

}
