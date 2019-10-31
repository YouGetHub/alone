package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * @author zou
 * @date 2019/10/29
 */
@RequestMapping(value = "/123")
@Controller
public class FileUploadController {
    private static final Integer SIZE = 1000000;
    @RequestMapping("/img")
    private String img(){
        return "img";
    }
    @RequestMapping("/upload")
    private static Object uploadApk(@RequestParam("name")String name,@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model){
        HashMap<String, Object> map = new HashMap<>();
        if (file.getSize()>SIZE){
            map.put("code",500);
            map.put("msg","请上传1MB以内的图片");
            model.addAttribute("img","文件上传失败 请上传1MB以内的图片");
            return "img";
        } else if (file.isEmpty()&file != null){
            // 获取保存图片的路径
            String realPathrequest = request.getServletContext().getRealPath("C://Users/zouha/IdeaProjects/alone/src/main/resources/static");

        }
        //https://blog.csdn.net/tangpeng2018/article/details/79393023
        String scheme = request.getScheme()+"://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath();

        model.addAttribute("img","上传成功");
        return "img";
    }
}
