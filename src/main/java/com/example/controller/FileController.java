package com.example.controller;

import com.example.common.base.MyResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: dj
 * @create: 2021-06-23 08:40
 * @description:
 **/
@RestController
@RequestMapping("/home")
public class FileController {

    @PostMapping("/uploadFile")
    public MyResult uploadFile(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return MyResult.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        String filePath = "/Users/itinypocket/workspace/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }
        return null;
    }

    @GetMapping("/downloadFile/{key}")
    public MyResult downloadFile(@PathVariable String key) {
        return null;
    }

}
