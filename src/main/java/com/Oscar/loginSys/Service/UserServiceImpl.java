package com.Oscar.loginSys.Service;

import com.Oscar.loginSys.DAO.UserMapper;
import com.Oscar.loginSys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public List<User> getall() {
        return usermapper.getAll();
    }

    @Override
    public void insert(User user) {
        usermapper.insert(user);

    }
}
