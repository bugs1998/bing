package com.bing.img.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回消息
 *
 * @Author 黄超
 * @Date 2019/5/5 17:44
 */
@Data
public class Result implements Serializable {
    /**
     * 结果标记(true:执行成功 false:执行失败)
     */
    private Boolean flag;
    /**
     * 消息状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    private Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     *
     * @param data 返回数据
     * @return Result
     */
    public static com.bing.img.utils.Result success(Object data) {
        return new com.bing.img.utils.Result(true, 2000, "响应成功", data);
    }

    /**
     * 响应成功
     *
     * @return Result
     */
    public static com.bing.img.utils.Result success() {
        return new com.bing.img.utils.Result(true, 2000, "响应成功", null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     *
     * @return Result
     */
    public static com.bing.img.utils.Result error(String msg) {
        return new com.bing.img.utils.Result(false, 2400, msg, null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     *
     * @return
     */
    public static com.bing.img.utils.Result errorMsg(Integer code, String msg) {
        return new com.bing.img.utils.Result(false, code, msg, null);
    }

}
