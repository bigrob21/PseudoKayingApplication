package com.pseudokayak.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pseudokayak.internal.user.InternalUser;

public interface UserRepository extends MongoRepository<InternalUser, String> {

}
