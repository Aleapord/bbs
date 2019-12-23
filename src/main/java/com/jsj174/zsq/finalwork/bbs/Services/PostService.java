package com.jsj174.zsq.finalwork.bbs.Services;

import com.jsj174.zsq.finalwork.bbs.Mapper.PostMapper;
import com.jsj174.zsq.finalwork.bbs.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<Post> getAllPost() {
        return postMapper.getAllPost();
    }

    public List<Post> getAllSortedByTimePost() {
        return postMapper.getAllSortedByTimePosts();
    }

    /* 获得排序了的帖子列表 */
    public List<Post> getSortedPost() {
        List<Post> posts = getAllPost();
        ArrayList<Post> temp = new ArrayList<>();
        ArrayList<Post> temp_1 = new ArrayList<>();
        if(posts == null)
            return null;
        // 先获得所有的置顶的帖子
        for(Post i : posts) {
            if(i.getTop() > 0) {
                temp.add(i);
            }else {
                temp_1.add(i);
            }
        }

        temp_1.sort((p1, p2) -> p2.getTime().compareTo(p1.getTime()));

        temp.addAll(temp_1);

        return temp;
    }

    public List<Post> getUserPost(int userID) {
        return postMapper.getUserPost(userID);
    }

    public Post getPost(int postID) {
        return postMapper.getPost(postID);
    }

    public void addPost(Post post) {
        postMapper.addPost(post);
    }

    public void updatePostbyPost(Post post) {
        postMapper.updatePost(post);
    }

    public void updateSection(String section, int postID) {
        postMapper.updateSection(section, postID);
    }

    public void updatePoint(int point, int postID) {
        postMapper.updatePoint(point, postID);
    }

    public void updateReplies(int postID) {
        postMapper.updateReplies(postID);
    }

    public void deleteRepiles(int postID) {
        postMapper.deleteReplies(postID);
    }

    public void updateViews(int postID) {
        postMapper.updateViews(postID);
    }

    public void updateTop(int top, int postID) {
        postMapper.updateTop(top, postID);
    }
    public void updatePost(Post post){
        postMapper.updatePost(post);
    }

    public void updateLikes(int postID) {
        postMapper.updateLikes(postID);
    }

    public void deletePost(int postID) {
        postMapper.deletePost(postID);
    }

    public List<Post> getSectionPost(String section) {
        return postMapper.getSectionPost(section);
    }
}
