package com.jsj174.zsq.finalwork.bbs.Mapper;

import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment(userID,username,postID,comment)" +
            "value(#{userID},#{username},#{postID},#{comment}")
    void addComment(@Param("comment") Comment comment);

    @Delete("delete from comment where comment=#{commentID}")
    void deleteComment(@Param("commentID") int commentID);
}
