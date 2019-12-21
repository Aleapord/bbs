package com.jsj174.zsq.finalwork.bbs.Models;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
    private int postID;
    private int userID;
    private String username;
    private String title;
    private String content;
    private String section;
    private int point;
    private int replies;
    private int views;
    private int top;
    private int likes;
    private Date time;

    public Post() {

    }

    public Post(int postID, int userID, String username, String title, String content, String section, int point, int replies, int views, int top, int likes, Date time) {
        this.postID = postID;
        this.userID = userID;
        this.username = username;
        this.title = title;
        this.content = content;
        this.section = section;
        this.point = point;
        this.replies = replies;
        this.views = views;
        this.top = top;
        this.likes = likes;
        this.time = time;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + postID +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", section='" + section + '\'' +
                ", point=" + point +
                ", replies=" + replies +
                ", views=" + views +
                ", top=" + top +
                ", likes=" + likes +
                ", time=" + time +
                '}';
    }
}
