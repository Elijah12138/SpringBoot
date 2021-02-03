package com.example.demo4.controller;

import com.example.demo4.bean.User;
import com.example.demo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 插入数据
     *
     * @return
     */
    @GetMapping("/insert")
    public String insertData() {
        String name = "name1";
        int age = 20;
        boolean flag = userService.insertUserData(name, age);
        if (flag)
            return "插入数据成功";
        else
            return "插入数据失败";
    }

    /**
     * 删除数据
     *
     * @return
     */
    @GetMapping("/delete")
    public String deleteData() {
        String name = "name1";
        boolean flag = userService.deleteUserData(name);
        if (flag)
            return "删除数据成功";
        else
            return "删除数据失败";
    }

    /**
     * 更新数据
     *
     * @return
     */
    @GetMapping("/update")
    public String updateData() {
        String name = "name1";
        int age = 30;
        boolean flag = userService.updateUserData(name, age);
        if (flag)
            return "更新数据成功";
        else
            return "更新数据失败";
    }

    /**
     * 获取数据
     *
     * @return
     */
    @GetMapping("/get")
    public String getData() {
        String name = "name1";
        User user = userService.getUserData(name);
        return user.toString();
    }
}
