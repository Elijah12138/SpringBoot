package com.example.demo4.controller;

import com.example.demo4.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RestUserController {

    @Autowired
    UserService userService;

    /**
     * 测试参数的接收情况
     *
     * @param parm1
     * @param parm2
     * @param map
     * @return
     */
    @GetMapping("/test/{parm1}/{parm2}")
    public String TestRestParm(@PathVariable("parm1") String parm1,
                               @PathVariable("parm2") String parm2,
                               @PathVariable Map<String, String> map) {
        return "parm1 = " + parm1 + "; parm2 = " + parm2 + "; map = " + map;
    }

    /**
     * 获取用户数据
     *
     * @param name
     * @return
     */
    @GetMapping("/userRestData/{name}")
    public String UserRestGetData(@PathVariable("name") String name) {
        return userService.getUserData(name).toString();
    }

    /**
     * 删除用户数据
     *
     * @param name
     * @return
     */
    @DeleteMapping("/userRestData/{name}")
    public String UserRestDeleteData(@PathVariable("name") String name) {
        boolean flag = userService.deleteUserData(name);
        if (flag)
            return "删除数据成功";
        else
            return "删除数据失败";
    }

    /**
     * 更新用户数据
     *
     * @param name
     * @return
     */
    @PutMapping("/userRestData/{name}/{age}")
    public String UserRestPutData(
            @PathVariable("name") String name,
            @PathVariable("age") int age) {
        boolean flag = userService.updateUserData(name, age);
        if (flag)
            return "更新数据成功";
        else
            return "更新数据失败";
    }

    /**
     * 插入用户数据
     *
     * @param name
     * @return
     */
    @PostMapping("/userRestData/{name}/{age}")
    public String UserRestInsertData(
            @PathVariable("name") String name,
            @PathVariable("age") int age) {
        boolean flag = userService.insertUserData(name, age);
        if (flag)
            return "插入数据成功";
        else
            return "插入数据失败";
    }
}
