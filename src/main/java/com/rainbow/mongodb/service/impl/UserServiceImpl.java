package com.rainbow.mongodb.service.impl;


import com.rainbow.mongodb.entity.User;
import com.rainbow.mongodb.repository.UserRepository;
import com.rainbow.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional

    public void testSave(User user) {
        User user1=new User();

    }
}
