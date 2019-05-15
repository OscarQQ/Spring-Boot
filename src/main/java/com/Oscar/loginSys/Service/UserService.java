package com.Oscar.loginSys.Service;

import com.Oscar.loginSys.model.User;

import java.util.List;

public interface UserService {
     List<User> getall();

     void insert(User user);

     boolean validate(User user);
}
