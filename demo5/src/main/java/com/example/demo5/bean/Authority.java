package com.example.demo5.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户权限类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int authorityId;
    private String authorityName;
    private List<UserMsg> userList;
}
