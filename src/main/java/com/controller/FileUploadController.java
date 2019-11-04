package com.controller;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author zou
 * @date 2019/10/29
 */
@RequestMapping(value = "/FileUploadController")
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
        // 判断图片的大小
        if (file.getSize()>SIZE){
            map.put("code",500);
            map.put("msg","请上传1MB以内的图片");
            model.addAttribute("img","文件上传失败 请上传1MB以内的图片");
            return "imgsuccess";
        }
        //https://blog.csdn.net/tangpeng2018/article/details/79393023
        String scheme = request.getScheme()+"://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath();
        // 获取保存图片的路径
        String realPath = "D://Software/IntelliJ IDEA 2018.3.6/IdeaProjects/alone/src/main/resources/static/img";
        // 获取原文件名称
        String originalFilename = file.getOriginalFilename();
        // 重新命名上传文件名称
        String newFileName = name + "-" + UUID.randomUUID() + "-" + originalFilename;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, newFileName));
            model.addAttribute("img","上传成功");
            model.addAttribute("nameimg",scheme+"/static/img/"+newFileName);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("img","失败");
        }
        return "imgsuccess";
    }
}
