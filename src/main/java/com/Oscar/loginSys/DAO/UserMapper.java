package com.Oscar.loginSys.DAO;


import com.Oscar.loginSys.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // Using Mybatis to interact with mysql database

    @Select("SELECT * FROM login")
    List<User> getAll();

    @Insert("INSERT INTO login(email,password) VALUES (#{email},#{password})")
    void insert(User newppl);
}
