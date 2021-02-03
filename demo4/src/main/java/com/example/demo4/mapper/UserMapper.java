package com.example.demo4.mapper;

import com.example.demo4.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    /**
     * 插入数据
     *
     * @param name
     * @param age
     * @return
     */
    @Insert("INSERT INTO tb_user(name,age) VALUES (#{name}, #{age})")
    boolean insertData(String name, int age);

    /**
     * 删除数据
     *
     * @param name
     * @return
     */
    @Delete("DELETE FROM tb_user WHERE name=#{name}")
    boolean deleteData(String name);

    /**
     * 更新数据
     *
     * @param name
     * @param age
     * @return
     */
    @Update("UPDATE tb_user SET age=#{age} WHERE name=#{name}")
    boolean updateData(String name, int age);

    /**
     * 获取数据
     *
     * @param name
     * @return
     */
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name,age FROM tb_user where name=#{name}")
    User getData(String name);
}
