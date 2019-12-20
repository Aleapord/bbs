package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import sun.plugin.javascript.navig.LinkArray;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {

    @Select("为某一id查出所有帖子")
    List<Comment> getComments(@Param("postID")int postID);

    @Insert("插入评论")
    void addComment (@Param("comment") Comment comment);

    @Delete("删除评论")
    void deleteComment(@Param("commentID") int id);


}
