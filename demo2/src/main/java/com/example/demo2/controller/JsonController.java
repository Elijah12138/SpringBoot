package com.example.demo2.controller;

import com.example.demo2.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JsonController {

    @GetMapping("/json")
    public String JsonIndex() {
        return "json";
    }

//    /**
//     * 第一种接收Json的方式
//     * 通过@RequestBody接收
//     *
//     * @param user
//     * @return
//     */
//    @ResponseBody
//    @PostMapping("/jsonData")
//    public Map<String, String> PostJsonData(
//            @RequestBody User user) {
//        System.out.println("后端接收的数据为： " + user.toString());
//        Map<String, String> map = new HashMap<>();
//        map.put("code", "200");
//        map.put("msg", "接收json数据成功");
//        return map;
//    }

//    /**
//     * 第二种接收Json的方式
//     * 通过Map接收
//     *
//     * @param user
//     * @return
//     */
//    @ResponseBody
//    @PostMapping("/jsonData")
//    public Map<String, String> PostJsonData(@RequestBody Map<String, Object> user) {
//        System.out.println("后端接收的数据为： " + user);
//        Map<String, String> map = new HashMap<>();
//        map.put("code", "200");
//        map.put("msg", "接收json数据成功");
//        return map;
//    }

    /**
     * 第三种接收Json的方式
     * 接收具体的参数
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/jsonData")
    public Map<String, String> PostJsonData(@RequestParam("usr") String usr,
                                            @RequestParam("pwd") String pwd) {
        System.out.println("后端接收的数据为： " + usr + "-" + pwd);
        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "接收json数据成功");
        return map;
    }
}
