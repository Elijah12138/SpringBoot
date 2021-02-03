package com.example.demo5.controller;

import com.example.demo5.bean.UserMsg;
import com.example.demo5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 默认进入登录页面
     *
     * @return
     */
    @GetMapping("/")
    public String loginIndex(Model model) {
        model.addAttribute("info", "用户登录");
        return "login";
    }

    /**
     * 进入注册页面
     *
     * @return
     */
    @GetMapping("/register")
    public String registerIndex(Model model) {
        model.addAttribute("info", "用户注册");
        return "register";
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(@ModelAttribute("user") UserMsg user,
                           Model model) {
        return userService.register(user, model);
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        //这里什么都不错，由Spring Security负责登录验证
        return "/login";
    }

    /**
     * 普通用户登录成功界面
     *
     * @param model
     * @return
     */
    @GetMapping("/user/index")
    public String loginSuccess(Model model) {
        return userService.userLogin(model);
    }

    /**
     * 管理员登录成功界面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/index")
    public String main(Model model) {
        return userService.adminLogin(model);
    }

    /**
     * 用户退出登录
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return userService.logout(request, response);
    }

    /**
     * 权限异常处理方法
     *
     * @param model
     * @return
     */
    @GetMapping("/errorAccess")
    public String deniedAccess(Model model) {
        return userService.errorAccess(model);
    }
}
