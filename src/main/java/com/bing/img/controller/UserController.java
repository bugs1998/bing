package com.bing.img.controller;

import com.bing.img.service.impl.MusicDayServiceImpl;
import com.bing.img.service.impl.UserServiceImpl;
import com.bing.img.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘建
 * @date 2020/5/20 22:32
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MusicDayServiceImpl musicDayService;

    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable int id) {
        String massger = null;
        try {
            massger = userService.sel(id).toString();
        } catch (Exception e) {
            massger = e.getMessage();
        }
        return Result.success(massger);
    }


}

