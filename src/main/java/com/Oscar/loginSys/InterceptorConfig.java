package com.Oscar.loginSys;

import com.Oscar.loginSys.Interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private Interceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/all");
    }
}

