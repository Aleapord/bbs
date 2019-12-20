package com.jsj174.zsq.finalwork.bbs.Models;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
    private int id;
    private int userID;
    private String username;
    private String title;
    private String content;
    private String section;
    private int point;
    private int replies;
    private int views;
    private Date time;

    public Post() {

    }

    public Post(int id, int userID, String username, String title, String content, String section, int point, int replies, int views, Date time) {
        this.id = id;
        this.userID = userID;
        this.username = username;
        this.title = title;
        this.content = content;
        this.section = section;
        this.point = point;
        this.replies = replies;
        this.views = views;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
