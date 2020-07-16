package com.bing.img.entity;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author 刘建
 * @date 2020/5/20 22:34
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    @ApiParam("网易云Cookie")
    private String cookieMusic;

    @ApiParam("网易云参数1")
    private String encSecKey;

    @ApiParam("网易云参数2")
    private String params;

    public User() {
    }
}
