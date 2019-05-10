package com.Oscar.loginSys.Service;

import com.Oscar.loginSys.DAO.UserMapper;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // DAO layer setup
    @Autowired
    private UserMapper usermapper;

    /**
     * retrieve all users from mysql database
     */

    @Override
    public List<User> getall() {
        return usermapper.getAll();
    }

    /**
     * update the database, insert a specific user into the table
     */

    @Override
    public void insert(User user) {
        usermapper.insert(user);

    }
}
