package com.bing.img.service.impl;

import com.alibaba.fastjson.JSON;
import com.bing.img.entity.BingImg;
import com.bing.img.mapper.BingImgMapper;
import com.bing.img.service.BingImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 刘建
 * @date 2020/5/20 22:54
 */
@Service("bingImgServiceImpl")
public class BingImgServiceImpl implements BingImgService {

    @Resource
    private BingImgMapper bingImgMapper;

    @Override
    public List<BingImg> getImgAll(String width, String height) throws Exception {

        List<BingImg> bingImgs = new ArrayList<BingImg>();
        StringBuilder json = new StringBuilder();
        int i = 0;

        URL url = new URL("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&uhd=1&uhdwidth=" + width + "&uhdheight=" + height);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        //截取头部img
        json.append(in.readLine().toString().substring(11));

        //截取尾部分页信息
        String s1 = json.toString().substring(0, json.lastIndexOf("],\""));

        //分组
        String[] s2 = s1.split("},");

        //遍历赋值
        for (String key : s2) {
            //最后一个不补充有大括号
            if (i < s2.length - 1) {
                key = key + "}";
            }
            bingImgs.add(JSON.parseObject(key, BingImg.class));
            i++;
        }
        return bingImgs;
    }

    /**
     * 将getimgAll的数据存入数据库
     *
     * @param bingImgs
     * @return
     */
    @Override
    public int insImgTiming(List<BingImg> bingImgs) {

        List<BingImg> imgs = bingImgMapper.queryImgIndex(8);

        if (imgs.size() != 0) {
            for (int j = 0; j < bingImgs.size() - 1; j++) {
                if (bingImgMapper.selAll(bingImgs.get(j).getStartDate().toString()) == 0) {
                    bingImgs.get(j).setUrlBase("https://cn.bing.com" + bingImgs.get(j).getUrlBase());
                    bingImgs.get(j).setUrlOne("https://cn.bing.com" + bingImgs.get(j).getUrlBase() + "_UHD.jpg");
                    bingImgs.get(j).setUrlTwo(bingImgs.get(j).getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4");
                    bingImgs.get(j).setUrlThree(bingImgs.get(j).getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=2560&h=1440&rs=1&c=4");
                    bingImgs.get(j).setUrlFour(bingImgs.get(j).getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=1920&h=1080&rs=1&c=4");
                    bingImgs.get(j).setQuiz("https://cn.bing.com" + bingImgs.get(j).getQuiz());
                    bingImgs.get(j).setCreationDate(new Date());
                    bingImgMapper.insTimingImg(bingImgs.get(j));
                }
            }
        } else {
            for (BingImg bingImg : bingImgs) {
                bingImg.setUrlBase("https://cn.bing.com" + bingImg.getUrlBase());
                bingImg.setUrlOne(bingImg.getUrlBase() + "_UHD.jpg");
                bingImg.setUrlTwo(bingImg.getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4");
                bingImg.setUrlThree(bingImg.getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=2560&h=1440&rs=1&c=4");
                bingImg.setUrlFour(bingImg.getUrlBase() + "_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=1920&h=1080&rs=1&c=4");
                bingImg.setQuiz("https://cn.bing.com" + bingImg.getQuiz());
                bingImg.setCreationDate(new Date());
                bingImgMapper.insTimingImg(bingImg);
            }
        }
        return imgs.size();
    }

    @Override
    public List<BingImg> getAll(int index) {
        System.out.println("1");
        return bingImgMapper.queryImgIndex(index);
    }
}
