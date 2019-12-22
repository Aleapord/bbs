package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PostMapper {

    @Select("select * from post order by top desc")
    List<Post> getAllPost();

    @Select("select * from post where userID = #{userID}")
    List<Post> getUserPost(@Param("userID") int userID);

    @Select("select * from post where postID = #{postID}")
    Post getPost(@Param("postID") int postID);

    @Insert("insert into post(userID,username,title,content,section,point,time)" +
            "values(#{post.userID},#{post.username},#{post.title},#{post.content},#{post.section},#{post.point},#{post.time})")
    void addPost(@Param("post") Post post);

    @Update("update post set title=#{post.title},content=#{post.content} where postID=#{post.postID}")
    void updatePost(@Param("post") Post post);

    @Update("update post set section=#{section} where postID=#{postID}")
    void updateSection(@Param("section") String section, @Param("postID") int postID);

    @Update("update post set point=#{point} where postID=#{postID}")
    void updatePoint(@Param("point") int point, @Param("postID") int postID);

    @Update("update post set replies=replies+1 where postID=#{postID}")
    void updateReplies(@Param("postID") int postID);

    @Update("update post set replies=replies-1 where postID=#{postID}")
    void deleteReplies(@Param("postID") int postID);

    @Update("update post set views=views+1 where postID=#{postID}")
    void updateViews(@Param("postID") int postID);

    @Update("update post set top=#{top} where postID=#{postID}")
    void updateTop(@Param("top") int top, @Param("postID") int postID);

    @Update("update post set likes=likes+1 where postID=#{postID}")
    void updateLikes(@Param("postID") int postID);
}
