package com.rainbow.repository;

import com.rainbow.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class TestRepositoryImpl implements TestRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void test() {

        Person person=entityManager.find(Person.class,11);
        System.out.println(person);
    }
}
