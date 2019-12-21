package com.jsj174.zsq.finalwork.bbs.Services;

import com.jsj174.zsq.finalwork.bbs.Mapper.CommentMapper;
import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public void deleteComment(int commentID) {
        commentMapper.deleteComment(commentID);
    }
}
