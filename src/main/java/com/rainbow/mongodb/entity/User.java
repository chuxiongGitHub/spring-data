package com.rainbow.mongodb.entity;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class User extends BaseID {

    private String userName;
    private String sex;
    private Integer age;

    public User(String userName, String sex, Integer age) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
