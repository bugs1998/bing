package com.bing.img.service;

import com.bing.img.entity.User;

/**
 * @author 刘建
 * @date 2020/5/20 22:51
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return User
     */
    public User sel(int id);
}
