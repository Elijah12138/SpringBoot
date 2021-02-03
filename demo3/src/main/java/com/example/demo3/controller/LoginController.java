package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * 进入index页面
     *
     * @return
     */
    @GetMapping("/indexPage")
    public String indexPage() {
        return "index";
    }

    /**
     * 进入login页面
     *
     * @return
     */
    @GetMapping("/loginPage")
    public String loginPage() throws ArithmeticException {
        System.out.println(1 / 0);
        return "login";
    }
}
