package com.test.hxd.demo.mapper;

import com.test.hxd.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author:   86155
 * Date:     2019/7/11 22:23
 */
@Mapper
public interface UserMapper {
    @Insert( "insert into user (name,accountId,token,gmtCreate,gmtModified,bio,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    public  void  insert(User user);

    @Select("select * from user where token = #{token} ")
    User findByToken(@Param("token") String token);
}
