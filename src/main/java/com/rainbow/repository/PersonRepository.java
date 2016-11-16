package com.rainbow.repository;

import com.rainbow.entity.Person;
import com.rainbow.entity.User;
import org.springframework.data.repository.Repository;

/**
 * Created by rainbow on 2016/11/16.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface PersonRepository extends Repository<Person,Integer> {
    Person findByLastName(String lastName);
}
