package com.example.demo2.controller;

import com.example.demo2.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @GetMapping("/form")
    public String FormIndex() {
        return "form";
    }

    /**
     * 获取表单数据
     *
     * @param usr
     * @param pwd
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/formData")
    public String PostFormData(
            @RequestParam("usr") String usr,
            @RequestParam("pwd") String pwd,
            @ModelAttribute User user) {
        return "usr = " + usr + "  pwd = " + pwd + "  user.toString =" + user.toString();
    }
}
