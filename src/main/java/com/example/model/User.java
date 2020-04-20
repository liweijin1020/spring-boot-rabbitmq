package com.example.model;

import java.io.Serializable;

/**
 * @author norhtking
 */
public class User implements Serializable {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User={'userName':'"+this.userName+"','passWord':'"+this.passWord+"'}";
    }
}
