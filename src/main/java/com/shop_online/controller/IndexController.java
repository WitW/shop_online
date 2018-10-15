package com.shop_online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //跳转登录界面
    @RequestMapping("index")
    public String login(){
        return "/user/index";
    }


    //跳转注册界面
    @RequestMapping("register")
    public String register(){
        return "/user/register";
    }
}
