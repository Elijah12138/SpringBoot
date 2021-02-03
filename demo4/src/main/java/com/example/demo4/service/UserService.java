package com.example.demo4.service;

import com.example.demo4.bean.User;

public interface UserService {

    /**
     * 插入数据
     *
     * @param name
     * @param age
     * @return
     */
    boolean insertUserData(String name, int age);

    /**
     * 删除数据
     *
     * @param name
     * @return
     */
    boolean deleteUserData(String name);

    /**
     * 更新数据
     *
     * @param name
     * @param age
     * @return
     */
    boolean updateUserData(String name, int age);

    /**
     * 获取用户数据
     *
     * @param name
     * @return
     */
    User getUserData(String name);
}
