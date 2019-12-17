package com.jsj174.zsq.finalwork.bbs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

}
