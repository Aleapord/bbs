package com.jsj174.zsq.finalwork.bbs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/section")
    public String section() {
        return "page-categories";
    }

    @GetMapping("/single-section")
    public String singleSection() {
        return "page-categories-single";
    }

    @GetMapping("/create-forum")
    public String createForum() {
        return "page-create-topic";
    }

    @GetMapping("/user-setting")
    public String userSetting() {
        return "page-single-user";
    }

    @GetMapping("/single-forum")
    public String singleForum() {
        return "page-single-topic";
    }

    @GetMapping("/update-forum")
    public String updateForum() {
        return "page-edit-post";
    }

    @GetMapping("/error")
    public String tellError() {
        return "error404";
    }
}
