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
     * 用户登录
     */

}
