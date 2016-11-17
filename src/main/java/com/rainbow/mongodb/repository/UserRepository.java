package com.rainbow.mongodb.repository;

import com.rainbow.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rainbow on 2016/11/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface UserRepository extends MongoRepository<User,String> {

}
