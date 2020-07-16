package com.bing.img.mapper;

import com.bing.img.entity.BingImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘建
 * @date 2020/5/20 22:36
 */
@Mapper
public interface BingImgMapper {

    /**
     * 定时任务存入图片
     *
     * @param bingImg
     */
    @Insert({"insert into bing_img(start_date,full_start_date,end_date,url_one,url_two,url_three,url_four,url_base,copy_right,copy_right_link,title,quiz,creation_date) values(#{startDate},#{fullStartDate},#{endDate},#{urlOne},#{urlTwo},#{urlThree},#{urlFour},#{urlBase},#{copyRight},#{copyRightLink},#{title},#{quiz},#{creationDate})"})
    public void insTimingImg(BingImg bingImg);

    /**
     * 查询图片信息
     *
     * @param index
     * @return BingImg
     */
    @Select({"<script>",
            "select * from bing_img",
            "<when test = 'index != 0'>",
            "limit #{index}",
            "</when>",
            "</script>"})
    public List<BingImg> queryImgIndex(@Param("index") int index);

    /**
     * 查询所有
     *
     * @param startDate
     * @return int
     */
    @Select({
            "<script>",
            "select count(1) from bing_img",
            "<when test = 'startDate != null'>",
            "where start_date = #{startDate}",
            "</when>",
            "</script>"
    })
    public int selAll(@Param("startDate") String startDate);

}
