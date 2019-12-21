package com.jsj174.zsq.finalwork.bbs.Services;

import com.jsj174.zsq.finalwork.bbs.Mapper.CommentMapper;
import com.jsj174.zsq.finalwork.bbs.Models.Comment;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public Post getComment(int postID){
        return commentMapper.getComment(postID);
    }

    public void deleteComment(int commentID) {
        commentMapper.deleteComment(commentID);
    }
    public List<Comment> getComments(int postID){
        return commentMapper.getComments(postID);
    }
}
