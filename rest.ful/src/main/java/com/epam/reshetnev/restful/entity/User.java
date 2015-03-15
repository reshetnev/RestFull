package com.epam.reshetnev.restful.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String userId;
    private String userName;
    private String login;
    private String password;

    //For JAXBE
    public User() {

    }

    public User(String userId, String userName, String login, String password) {
        this.userId = userId;
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

}
