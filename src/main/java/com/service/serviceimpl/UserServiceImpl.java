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

    /**
     * 使用手机号登陆
     * @param phonenumber
     * @param password
     * @return
     */
    @Override
    public String findUserLogin(String phonenumber, String password) {
        String userLogin = userMapper.findUserLogin(phonenumber, password);
        if (userLogin == null){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 使用邮箱登陆findUserEmailLogin
     * @param email
     * @param password
     * @return
     */
    @Override
    public String findUserEmailLogin(String email, String password) {
        String userEmailLogin = userMapper.findUserEmailLogin(email, password);
        if (userEmailLogin == null){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 使用用户名登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public String findUserUserNameLogin(String username, String password) {
        String userUserNameLogin = userMapper.findUserUserNameLogin(username, password);
        if (userUserNameLogin == null){
            return "0";
        }else{
            return "1";
        }
    }


}
