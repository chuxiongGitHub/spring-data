package com.rainbow.service.impl;

import com.rainbow.entity.Person;
import com.rainbow.repository.PersonRepository;
import com.rainbow.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    @Transactional
    public int updateLastName(String email, Integer id) {
        int count=personRepository.updatePersonLastName("dd",1);
        return count;
    }
    @Transactional
    @Override
    public void savePersons(List<Person> list) {
         personRepository.save(list);
    }
}
