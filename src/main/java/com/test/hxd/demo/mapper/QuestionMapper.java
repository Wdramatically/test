package com.test.hxd.demo.mapper;

import com.test.hxd.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author:   86155
 * Date:     2019/7/25 22:41
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,gmt_create,gmt_modified,creator,tag,description) values (#{title},#{gmtCreate},#{gmtModified},#{creator},#{tag},#{description}")
    public void create(Question question);
}
