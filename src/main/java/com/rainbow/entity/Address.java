package com.rainbow.entity;

import javax.persistence.Entity;

/**
 * Created by rainbow on 2016/11/16.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Entity
public class Address extends AbstractEntity {
    private String street;
    private String city;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
