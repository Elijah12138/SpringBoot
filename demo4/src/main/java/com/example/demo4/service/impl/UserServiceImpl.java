package com.example.demo4.service.impl;

import com.example.demo4.bean.User;
import com.example.demo4.mapper.UserMapper;
import com.example.demo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 插入数据
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public boolean insertUserData(String name, int age) {
        return userMapper.insertData(name, age);
    }

    /**
     * 删除数据
     *
     * @param name
     * @return
     */
    @Override
    public boolean deleteUserData(String name) {
        return userMapper.deleteData(name);
    }

    /**
     * 更新数据
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public boolean updateUserData(String name, int age) {
        return userMapper.updateData(name, age);
    }

    /**
     * 获取数据
     *
     * @param name
     * @return
     */
    @Override
    public User getUserData(String name) {
        return userMapper.getData(name);
    }
}
