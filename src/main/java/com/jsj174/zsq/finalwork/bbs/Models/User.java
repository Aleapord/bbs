package com.jsj174.zsq.finalwork.bbs.Models;

public class User {
    private int userID;
    private String username;
    private String password;
    private String gender;
    private String address;
    private String job;
    private int wealth;
    private int telephone;


    public User() {
    }

    public User(int userID, String username, String password, String gender, String address, String job, int wealth, int telephone) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.job = job;
        this.wealth = wealth;
        this.telephone = telephone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}