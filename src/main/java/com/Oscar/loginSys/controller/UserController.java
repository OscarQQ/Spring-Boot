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


    /**From Controller, applying service layer method, return JSON data
     *
     * @return all users in the database of JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll(){ return userservice.getall(); }

    /** root of the website, direct to the index.html under the templates
     * folder through thymeleaf
     *
     * @return index page
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /** Go to signup page. Ask the user to fill in the info
     *
     * @param map
     * @return signup.html
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Map<String,Object> map) {
        map.put("user",new User());
        return "signup";
    }

    /** If successfully validate the input, direct to main page, otherwise go back to sign up page
     *
     * @param user
     * @param bindingResult
     * @return index page or sign up page
     */
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
