package com.Oscar.loginSys;

import com.Oscar.loginSys.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MappedTypes(User.class)
@MapperScan("com.Oscar.loginSys.DAO")
@SpringBootApplication
public class LoginSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSysApplication.class, args);
	}

}
