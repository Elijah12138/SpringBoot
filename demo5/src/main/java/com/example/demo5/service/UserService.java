package com.example.demo5.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo5.bean.UserMsg;
import org.springframework.ui.Model;

public interface UserService {
    public String register(UserMsg user, Model model);

    public String userLogin(Model model);

    public String adminLogin(Model model);

    public String errorAccess(Model model);

    public String logout(HttpServletRequest request, HttpServletResponse response);
}
