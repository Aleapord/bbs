package com.jsj174.zsq.finalwork.bbs.Services;

import com.jsj174.zsq.finalwork.bbs.Mapper.PostMapper;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostMapper postMapper;

    public List<Post> getAllPost(){
        return postMapper.getAllPost();
    }
    public List<Post> getUserPost(int userID){
        return postMapper.getUserPost(userID);
    }
    public Post getPost(int postID){
        return postMapper.getPost(postID);
    }
    public void addPost(Post post){
        postMapper.addPost(post);
    }
    public void updatePost(Post post){
        postMapper.updatePost(post);
    }
    public void updateSection(String section,int postID){
        postMapper.updateSection(section,postID);
    }
    public void updatePoint(int point,int postID){
        postMapper.updatePoint(point,postID);
    }
    public void updateReplies(int replies,int postID){
        postMapper.updateReplies(replies,postID);
    }
    public void updateViews(int views,int postID){
        postMapper.updateViews(views,postID);
    }
    public void updateTop(int top,int postID){
        postMapper.updateTop(top,postID);
    }
    public void updateLikes(int likes,int postID){
        postMapper.updateLikes(likes,postID);
    }
}
