package com.ep.controller;


import com.ep.domain.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    /*
    * 文件上传
    * */
    @PostMapping(value = "/upload")
    @ResponseBody
    public ResultInfo fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        ResultInfo info = new ResultInfo();

        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://uploads//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            info.setStatus(200);
            info.setMsg("上传文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            info.setStatus(400);
            info.setMsg("上传文件失败");
        }
        String filename = "/uploads/" + fileName;
        //model.addAttribute("filename", filename);
        info.setData(filename);
        System.out.println(filename);
        return info;
    }

}
