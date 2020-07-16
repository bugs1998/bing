package com.bing.img.service;

import com.bing.img.entity.User;

/**
 * @author 刘建
 * @date 2020/6/1 12:40
 */
public interface MusicDayService {

    /**
     * 网易云日推
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Object toDaysMusic(User user) throws Exception;
}
