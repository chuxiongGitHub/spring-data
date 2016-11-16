package com.rainbow.entity;

import javax.persistence.Entity;

/**
 * Created by rainbow on 2016/11/16.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class User {

    private Long id;

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
