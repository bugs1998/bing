package com.bing.img.entity;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * @author 刘建
 * @date 2020/6/3 23:56
 */
@Data
public class MusicDay {

    @ApiParam("'歌曲名称'")
    private String music_name;

    @ApiParam("'原唱或出处'")
    private String alias;

    @ApiParam("演唱者")
    private String artists;

    @ApiParam("歌曲ID")
    private Integer music_id;

    @ApiParam("推荐原因")
    private String reason;

    @ApiParam("日推日期")
    private Date music_date;

    @ApiParam("用户ID")
    private Integer user_id;

    @ApiParam("数据创建时间")
    private String gmt_create;

    @ApiParam("数据更新时间")
    private String gmt_modified;

}
