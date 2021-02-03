package com.example.demo2.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class FilesController {

    @GetMapping("/file")
    public String FilesIndex(Model model) {
        // 保存文件的路径
        String path = "C:/Users/Elijah/Desktop/upload";
        // 获取目标文件夹下的文件列表
        File fileDir = new File(path);
        File[] filesList = fileDir.listFiles();
        model.addAttribute("filesList", filesList);
        return "file";
    }

    /**
     * 文件上传
     *
     * @param request
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("/filesUpload")
    public String FilesUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = "C:/Users/Elijah/Desktop/upload";
            // 获取上传文件名
            String fileName = file.getOriginalFilename();
            File filePath = new File(path + File.separator + fileName);
            // 如果文件目录不存在，则自动创建
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            // 上传文件
            file.transferTo(filePath);
            return "上传文件成功";
        }
        return "上传文件失败";
    }

    @GetMapping("/filesDownload")
    public ResponseEntity<byte[]> FilesDownload(HttpServletRequest request,
                                                @RequestParam("fileName") String fileName,
                                                @RequestHeader("User-Agent") String userAgent) throws IOException {
        // 下载文件路径
        String path = "C:/Users/Elijah/Desktop/upload";
        // 下载文件
        File downFileDir = new File(path + File.separator + fileName);
        BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(downFileDir.length());
        // 对文件名进行编码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        if (userAgent.indexOf("MSIE") > 0) {
            builder.header("Content-Disposition", "attachment;filename = " + fileName);
        } else {
            builder.header("Content-Disposition", "attachment;filename *= UTF-8");
        }
        return builder.body(FileUtils.readFileToByteArray(downFileDir));
    }
}
