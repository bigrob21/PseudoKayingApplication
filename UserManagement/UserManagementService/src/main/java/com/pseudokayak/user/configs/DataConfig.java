package com.pseudokayak.user.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages= {"com.pseudokayak.user.repository"})
public class DataConfig {
	
	public MongoTemplate mongoTemplate(@Autowired(required=true) MongoTemplate template) {
		template.getConverter().
	}
}
