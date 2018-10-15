package com.shop_online.controller;

import com.shop_online.bean.User;
import com.shop_online.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @RequestMapping(value = "/registerUser")
    @ResponseBody
    public Map registerUser(@RequestParam("email")String email, @RequestParam("password")String password,
                                            @RequestParam("phone")String phone, @RequestParam("username")String username){
        Map<String,Object> mapRegister = new HashMap<String, Object>();
        String image_url = "/image/user_image/default_image.jpg";
        System.out.println("hello");
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setType("普通用户");
        user.setImage(image_url);
        userRespository.save(user);
        mapRegister.put("msg","创建成功");
        return mapRegister;
    }

    @RequestMapping(value = "/loginUser")
    @ResponseBody
    public Map loginUser(@RequestParam("email")String email, @RequestParam("password")String password, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> mapLogin = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String msg = null;
        User user = userRespository.findUserByEmailAndPassword(email,password);
        if (user==null){
            msg = "error";
        }else {
            msg = "success";
            session.setAttribute("email",email);
        }
        mapLogin.put("msg",msg);
        return mapLogin;
    }

    @RequestMapping(value = "/updateUserInfo")
    public String updateUserInfo(){
        return null;
    }

    @RequestMapping(value = "/showUserInfo")
    @ResponseBody
    public List<User> showUserInfo(HttpServletRequest request, HttpSession session){
        String email = (String) session.getAttribute("email");
        List<User> list  = userRespository.findUserByEmail(email);

        return list;
    }

    @RequestMapping(value = "/usercenter-info")
    public String usercenter_info(){
        return "/user/usercenter-info";
    }


}
