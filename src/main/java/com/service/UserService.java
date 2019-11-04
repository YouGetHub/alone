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
    int findUserLogin(String phonenumber,String password);
}
