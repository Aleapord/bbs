package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PostMapper {

    @Select("select * from post order by top")
    List<Post> getAllPost();

    @Select("select * from post where userID = #{userID}")
    List<Post> getUserPost(@Param("userID") int userID);

    @Select("select * from post where postID = #{postID}")
    Post getPost(@Param("postID") int postID);

    @Insert("insert into post(userID,username,title,content,section,point,time" +
            "values(#{userID},#{username},#{title},#{content},#{section},#{point},#{time}")
    void addPost(@Param("post") Post post);

    @Update("update post set title=#{title},content=#{content} where postID=#{postID}")
    void updatePost(@Param("post") Post post);

    @Update("update post set section=#{section} where postID=#{postID}")
    void updateSection(String section,int postID);

    @Update("update post set point=#{point} where postID=#{postID}")
    void updatePoint(int point,int postID);

    @Update("update post set replies=#{replies}+1 where postID=#{postID}")
    void updateReplies(int postID);

    @Update("update post set replies=#{replies}-1 where postID=#{postID}")
    void deleteReplies(int postID);

    @Update("update post set views=#{views}+1 where postID=#{postID}")
    void updateViews(int postID);

    @Update("update post set top=#{top} where postID=#{postID}")
    void updateTop(int top,int postID);

    @Update("update post set likes=#{likes}+1 where postID=#{postID}")
    void updateLikes(int postID);
}
