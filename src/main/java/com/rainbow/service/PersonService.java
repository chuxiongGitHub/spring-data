package com.rainbow.service;

import com.rainbow.entity.Person;

import java.util.List;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface PersonService {

    int updateLastName(String email,Integer id);

    void savePersons(List<Person> list);
}
