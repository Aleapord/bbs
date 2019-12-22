package com.jsj174.zsq.finalwork.bbs.Models;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentID;
    private int userID;
    private String username;
    private int postID;
    private String comment;
    private int answer;
    private String time;

    public Comment() {
    }

    public Comment(int commentID, int userID, String username, int postID, String comment, int answer, String time) {
        this.commentID = commentID;
        this.userID = userID;
        this.username = username;
        this.postID = postID;
        this.comment = comment;
        this.answer = answer;
        this.time = time;
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

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", postID=" + postID +
                ", comment='" + comment + '\'' +
                ", answer=" + answer +
                ", time='" + time + '\'' +
                '}';
    }
}
