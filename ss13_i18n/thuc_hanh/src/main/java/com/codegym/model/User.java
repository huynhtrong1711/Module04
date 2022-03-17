package com.codegym.model;

public class User {

    private int id;
    private String nameUser;
    private String password;

    public User() {
    }

    public User(int id, String nameUser, String password) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
