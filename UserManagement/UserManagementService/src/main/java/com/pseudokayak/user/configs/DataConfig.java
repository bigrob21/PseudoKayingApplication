package com.pseudokayak.user.configs;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages= {"com.pseudokayak.user.repository"})
public class DataConfig {

}
