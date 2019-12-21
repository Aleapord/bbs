package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment(userID,username,postID,comment)" +
            "value(#{comment.userID},#{comment.username},#{comment.postID},#{comment.comment}")
    void addComment(@Param("comment") Comment comment);

    @Select("select username,comment from comment where postID=#{postID}")
    Post getComment(@Param("postID") int postID);

    @Delete("delete from comment where comment=#{commentID}")
    void deleteComment(@Param("commentID") int commentID);
}
