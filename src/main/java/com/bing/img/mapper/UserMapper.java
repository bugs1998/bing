package com.bing.img.mapper;

import com.bing.img.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 刘建
 * @date 2020/5/20 22:42
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    User sel(@Param("id") int id);
}
