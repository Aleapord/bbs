package com.jsj174.zsq.finalwork.bbs.Models;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentID;
    private int userID;
    private String username;
    private int postID;
    private String comment;

    public Comment() {
    }

    public Comment(int commentID, int userID, String username, int id, String comment) {
        this.commentID = commentID;
        this.userID = userID;
        this.username = username;
        this.postID = id;
        this.comment = comment;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", postID=" + postID +
                ", comment='" + comment + '\'' +
                '}';
    }
}
