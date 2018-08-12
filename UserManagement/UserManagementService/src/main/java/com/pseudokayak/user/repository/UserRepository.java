package com.pseudokayak.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pseudokayak.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
