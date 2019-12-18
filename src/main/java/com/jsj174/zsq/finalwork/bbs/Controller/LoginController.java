package com.jsj174.zsq.finalwork.bbs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("login/")
    @ResponseBody
    public HashMap<String,Object> login(){
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("msg","Hello");
        return hashMap;
    }

}
