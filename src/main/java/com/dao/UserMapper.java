package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zou
 * @date 2019/10/24
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<User> selectUserAll();

    /**
     * 注册
     * @param user
     * @return
     */
    int insertUserRegistered(User user);

    /**
     * 验证username是否存在
     */
    String selectUserByUserName(String username);

    /**
     * 使用手机号登陆
     */
    String findUserLogin(String phonenumber,String password);

    /**
     * 使用邮箱登陆
     */
    String findUserEmailLogin(String email,String password);

    /**
     * 使用用户名登陆
     * @param username
     * @param password
     * @return
     */
    String findUserUserNameLogin(String username,String password);

    
}
