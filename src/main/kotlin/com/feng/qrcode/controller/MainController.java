package com.feng.qrcode.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    @RequestMapping(value="/hello")
    public String helloWorld(HttpServletRequest request) {
        return "hello world!";
    }

}
