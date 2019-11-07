package com.service;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @date 2019/10/24
 */
public interface UserService {
    /**
     * 查询所有数据
     * @return
     */
    List<User> selectUserAll();

    /**
     * 用户注册
     * @param user
     * @return
     */
    int insertUserRegistered(User user);

    /**
     * 用户注册验证用户名是否存在
     * @param username
     * @return
     */
    String selectUserByUserName(String username);

    /**
     * 使用手机号登陆
     * @param phonenumber
     * @param password
     * @return
     */
    String findUserLogin(String phonenumber,String password);

    /**
     * 使用邮箱登陆
     * @param email
     * @param password
     * @return
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