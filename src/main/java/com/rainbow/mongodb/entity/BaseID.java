package com.rainbow.mongodb.entity;


import org.springframework.data.annotation.Id;

import javax.annotation.Generated;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class BaseID {

    @Id
    @Generated(value = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
