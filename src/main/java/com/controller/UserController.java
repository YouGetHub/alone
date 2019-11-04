package com.controller;

import com.entity.User;
import com.entity.UserLogin;
import com.service.UserService;
import org.apache.tomcat.jni.Multicast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zou
 * @date 2019/10/24
 */
@RequestMapping("/UserController")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转注册页面
     */
    @RequestMapping(value = "/register")
    private String registerHtml(){
        return "regist";
    }

    /**
     * 用户注册验证用户名是否存在
     * @param username
     * @return
     */
    @RequestMapping(value = "/selectUserByUserName")
    @ResponseBody
    private boolean selectUserByUserName(String username){
        System.out.println(username);
        boolean b = true;
        System.out.println(userService.selectUserByUserName(username));
        if (userService.selectUserByUserName(username) == null){
            // 账号可以使用
            return b;
        }else{
            // 账号不可以使用
            return false;
        }
    }

    /**
     * 添加一条数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertUserRegistered" ,method = {RequestMethod.POST})
    private Object insertUserRegistered(User user, Model model) {
        int i = userService.insertUserRegistered(user);
        // 获取主键 selectKey
        System.out.println(user.toString());
        if (i>=1){
            return "redirect:/UserController/login";
        }else{
            model.addAttribute("error","注册失败");
            return "error";
        }
    }

    /**
     * 跳转登录界面
     */
    @RequestMapping(value = "/login")
    private String login(){
        return "login";
    }

    /**
     * 登录验证
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/userLogin")
    @ResponseBody
    private String findUserLogin(@RequestBody UserLogin userLogin){
        System.out.println(userLogin.getAccount()+"=="+userLogin.getPassword());
        // 手机号登陆
        if (userLogin.getAccount().matches("0?(13|14|15|18)[0-9]{9}")){
            if (userService.findUserLogin(userLogin.getAccount(),userLogin.getPassword())>0){
                return "true";
            }
        }
        return "false";
    }

    /**
     * 查询所有的数据
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    private List<User> selectUserAll(){
        List<User> users = userService.selectUserAll();
        return users;
    }
}
