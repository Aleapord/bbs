package com.jsj174.zsq.finalwork.bbs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author amorjoo.ncu
 * @version 1.8
 * @description //TODO
 * @date 2019/12/19 14:10
 */
@Controller
@RequestMapping("/categories")
public class CategoriesCotroller {
    @GetMapping("/")
    public String categories() {
        return "page-categories";
    }
}
