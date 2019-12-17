package com.jsj174.zsq.finalwork.bbs.Models;

public class User {
    private int id;
    private String name;
    private String password;
    private String icon;
    private int wealth;

    public User() {
    }

    public User(int id, String name, String password, String icon, int wealth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.icon = icon;
        this.wealth = wealth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }
}
