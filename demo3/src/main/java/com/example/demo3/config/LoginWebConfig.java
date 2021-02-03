package com.example.demo3.config;//package com.example.demo1.config;

import com.example.demo3.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/indexPage")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/loginPage"); //放行的请求
    }
}
