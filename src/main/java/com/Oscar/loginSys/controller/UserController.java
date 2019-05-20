package com.Oscar.loginSys.controller;


import com.Oscar.loginSys.Response.Response;
import com.Oscar.loginSys.Service.UserService;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
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

    /** root of the website, direct to the index.html under the views
     * folder through thymeleaf
     *
     * @return index page
     */
    @RequestMapping("/")
    public String index(Map<String,Object> map) {
        map.put("user",new User());
        return "index";
    }

    /** Go to signin page. Ask the user to fill in the info
     *
     * @param map
     * @return signin.html
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Map<String,Object> map) {
        map.put("user",new User());
        return "signin";
    }

    /** If successfully validate the input, direct to success page, otherwise go back to error page
     *
     *
     * @return index page or sign up page
     */
    @PostMapping(value ="/signup")
    @ResponseBody
    public Response signup(@RequestBody User user){
        System.out.println("reach here");
        Response response = new Response("done",userservice.getall());
        if(! userservice.validate(user)){
            userservice.insert(user);
            return response;
        }else{
            response.setStatus("fail");
            return response;
        }

    }
}
