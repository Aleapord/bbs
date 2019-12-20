package com.jsj174.zsq.finalwork.bbs.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PostMapper {

    @Select("select * from post order by top")
    List<PostMapper> getAllPost();

    @Select("select * from post where userID = #{id}")
    PostMapper getPost(@Param("id") int id);

    @Insert("插入数据库")
    void addPost(@Param("post") PostMapper postMapper);

    @Update("修改数据库")
    void updatePost(@Param("post") PostMapper postMapper);
}
