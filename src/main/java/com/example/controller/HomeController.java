package com.example.controller;

import com.example.common.base.MyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dj
 * @create: 2021-06-22 09:05
 * @description:
 **/
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("test")
    public MyResult test() {
        return MyResult.ok();
    }

}
