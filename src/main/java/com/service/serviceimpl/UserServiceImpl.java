package com.service.serviceimpl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @date 2019/10/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public int insertUserRegistered(User user) {
        return userMapper.insertUserRegistered(user);
    }

    /**
     * 用户注册验证用户名是否存在
     * @param username
     * @return
     */
    @Override
    public String selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }


}
