package com.bing.img.controller;

import com.bing.img.entity.BingImg;
import com.bing.img.service.BingImgService;
import com.bing.img.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘建
 * @date 2020/5/20 22:30
 */
@Controller
@RequestMapping(value = "/api")
public class BingImgController {

    @Resource
    private BingImgService bingImgService;

    @GetMapping("/selectbing")
    @ResponseBody
    public Object getImgAll(String width, String right) {
        try {
            Object ob = bingImgService.getImgAll(width, right);
            return Result.success(ob);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/selectimglist/{id}")
    @ResponseBody
    public Object queryImgAll(@PathVariable Integer id) {

        //Integer index = Integer.parseInt(JSON.parseObject(id).get("id").toString());

        try {
            List<BingImg> list = bingImgService.getAll(id);
            return Result.success(list);
        } catch (Exception e) {
            return Result.errorMsg(2400, "未知错误:" + e.getMessage());
        }

    }
}
