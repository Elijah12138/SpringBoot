package com.example.demo5.mapper;

import com.example.demo5.bean.Authority;
import com.example.demo5.bean.UserMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Select("select * from tb_user where userName = #{userName}")
    UserMsg findByUsername(String userName);

    /**
     * 根据用户id查询用户权限
     *
     * @param userId
     * @return
     */
    @Select("select ua.authorityId, authorityName from tb_authority a, tb_user_authority ua where a.authorityId = ua.authorityId and ua.userId = #{userId}")
    List<Authority> findRoleByUser(Integer userId);

    /**
     * 在数据库中插入新注册的用户信息
     *
     * @param user
     * @return
     */
    @Insert("insert into tb_user(userId, userName, userPwd) values(null, #{userName},  #{userPwd})")
    boolean insertUserMsg(UserMsg user);

    /**
     * 在数据库中插入新注册用户的权限信息
     *
     * @param userId
     * @param authorityId
     * @return
     */
    @Insert("insert into tb_user_authority(userId, authorityId) values(#{userId},  #{authorityId})")
    boolean insertUserAuthority(@Param("userId") Integer userId,
                                @Param("authorityId") Integer authorityId);
}
