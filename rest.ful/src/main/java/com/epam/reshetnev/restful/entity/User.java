package com.epam.reshetnev.restful.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Comparable<User> {
    private Long userId;
    private String userName;
    private String login;
    private String password;

    public User(Long userId, String userName, String login, String password) {
        this.userId = userId;
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", login="
                + login + ", password=" + password + "]";
    }

    @Override
    public int compareTo(User arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

}
