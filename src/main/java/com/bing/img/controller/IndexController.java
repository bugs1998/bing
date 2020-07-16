package com.bing.img.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 刘建
 * @date 2020/5/20 21:47
 */
@Controller
@RequestMapping("/api")
public class IndexController {

    @RequestMapping("/test")
    public String getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        return "index";
    }
}
