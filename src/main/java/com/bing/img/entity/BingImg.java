package com.bing.img.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author 刘建
 * @date 2020/5/20 22:34
 */
@Data
public class BingImg {

    @JSONField(name = "startdate")
    private String startDate;

    @JSONField(name = "fullstartdate")
    private String fullStartDate;

    @JSONField(name = "enddate")
    private String endDate;

    @JSONField(name = "url")
    private String urlOne;

    private String urlTwo;
    private String urlThree;
    private String urlFour;

    @JSONField(name = "urlbase")
    private String urlBase;

    @JSONField(name = "copyright")
    private String copyRight;

    @JSONField(name = "copyrightlink")
    private String copyRightLink;

    private String title;
    private String quiz;
    private Date creationDate;
}