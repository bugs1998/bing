package com.bing.img.service;

import com.bing.img.entity.BingImg;

import java.io.IOException;
import java.util.List;

/**
 * @author 刘建
 * @date 2020/5/20 22:45
 */
public interface BingImgService {

    /**
     * 读取bing首页壁纸链接
     *
     * @param width
     * @param height
     * @return BingImg
     * @throws IOException
     * @throws Exception
     */
    public List<BingImg> getImgAll(String width, String height) throws IOException, Exception;

    /**
     * 将getimgAll的数据存入数据库
     *
     * @param bingImgs
     * @return int
     */
    public int insImgTiming(List<BingImg> bingImgs);

    /**
     * 读取全部数据
     *
     * @param index
     * @return BingImg
     */
    public List<BingImg> getAll(int index);
}

