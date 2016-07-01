package com.example.student.myapplication.database;

/**
 * Created by rome03 on 21/06/2016.
 */
public class User {

    private String login;
    private String pwd;

    public User(String login, String pwd) {

        this.login = login;
        this.pwd = pwd;
    }


    public User() {
    }

    public String getPwd() {
        return pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
