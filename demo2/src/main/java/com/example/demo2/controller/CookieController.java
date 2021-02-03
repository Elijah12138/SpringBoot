package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("cookie")
    public String CookieIndex() {
        return "cookie";
    }

    /**
     * 设置cookie的值
     *
     * @param response
     * @return
     */
    @ResponseBody
    @PostMapping("/setCookie")
    public String SetCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookie", "cookietest");
        response.addCookie(cookie);
        return "设置cookie成功";
    }

    /**
     * 获取cookie的值
     *
     * @param cookie
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/getCookie")
    public String GetCookie(@CookieValue("cookie") String cookie) throws Exception {
        return "获取cookie的值为" + cookie;
    }
}
