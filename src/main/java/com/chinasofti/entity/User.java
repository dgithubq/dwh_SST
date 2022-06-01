package com.chinasofti.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String userName;
    private String email;
    private String passWord;
    private String phoneNum;
    private List<Role> roles;

    public User(String userName, String email, String passWord, String phoneNum) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User(Integer id, String userName, String email, String passWord, String phoneNum, List<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
        this.roles = roles;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roles=" + roles +
                '}';
    }
}
