package com.bing.img.task;

import com.bing.img.entity.BingImg;
import com.bing.img.service.BingImgService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 刘建
 * @date 2020/5/20 23:02
 */
@Configuration
@EnableScheduling
public class AddImgAll {

    public static final String imgWidth = "3840";
    public static final String imgHeight = "2160";

    @Resource
    BingImgService bingImgService;

    //@Scheduled(cron = "0 0/1 * * * ?")
    private void addImgTaska() {
        try {

            List<BingImg> bingImgs = bingImgService.getImgAll(imgWidth, imgHeight);
            int i = bingImgService.insImgTiming(bingImgs);
            System.err.println("---" + new Date() + "---" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
