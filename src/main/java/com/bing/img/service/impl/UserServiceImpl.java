package com.bing.img.service.impl;

import com.bing.img.entity.User;
import com.bing.img.mapper.UserMapper;
import com.bing.img.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 刘建
 * @date 2020/5/20 22:59
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User sel(int id) {
        return userMapper.sel(id);
    }
}
