package com.example.demo5.service.impl;

import com.example.demo5.bean.UserMsg;
import com.example.demo5.mapper.UserMapper;
import com.example.demo5.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public String register(UserMsg user,
                           Model model) {
        String userName = user.getUserName();
        //加密密码
        String secret = new BCryptPasswordEncoder().encode(user.getUserPwd());
        user.setUserPwd(secret);
        // 查询该用户名是否已经注册
        try {
            userMapper.findByUsername(userName);

            boolean flag = userMapper.insertUserMsg(user);

            // 获取新插入到数据库中用户的ID
            user = userMapper.findByUsername(userName);

            // 管理员权限
            // 如果输入的用户名为admin，则注册为管理员账户
            // 其他的用户表注册为普通用户
            // 可根据实际情况进行修改
            if ("admin".equals(userName)) {
                userMapper.insertUserAuthority(user.getUserId(), 1);
            } else {
                //用户权限
                userMapper.insertUserAuthority(user.getUserId(), 2);
            }

            // 注册成功返回登录界面
            // 注册失败继续返回注册界面
            if (flag) {
                model.addAttribute("info", "注册成功，请登录账户");
                return "/login";
            }
            model.addAttribute("info", "注册失败，请重新注册");
            return "/register";
        } catch (Exception e) {
            log.info("该用户名已被注册");
            model.addAttribute("info", "该用户名已被注册，请重新注册");
            return "/register";
        }
    }

    /**
     * 用户登录
     */
    @Override
    public String userLogin(Model model) {
        model.addAttribute("user", getUname());
        model.addAttribute("role", getAuthorities());
        return "/user/index";
    }

    /**
     * 管理员登录
     */
    @Override
    public String adminLogin(Model model) {
        model.addAttribute("user", getUname());
        model.addAttribute("role", getAuthorities());
        return "/admin/index";
    }

    /**
     * 注销用户
     */
    @Override
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //获得用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            //注销
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    /**
     * 没有权限拒绝访问
     */
    @Override
    public String errorAccess(Model model) {
        model.addAttribute("user", getUname());
        model.addAttribute("role", getAuthorities());
        return "error";
    }

    /**
     * 获得当前用户名称
     */
    private String getUname() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * 获得当前用户权限
     */
    private String getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority ga : authentication.getAuthorities()) {
            roles.add(ga.getAuthority());
        }
        return roles.toString();
    }
}
