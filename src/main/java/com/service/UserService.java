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
     */
    String selectUserByUserName(String username);
}
