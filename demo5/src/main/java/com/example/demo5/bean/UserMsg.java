package com.example.demo5.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMsg {
    private int userId;
    private String userName;
    private String userPwd;
    private List<Authority> authorityList;
}
