package com.pseudokayak.user.configs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.pseudokayak.internal.user.utils.UserReaderConverter;
import com.pseudokayak.internal.user.utils.UserWriterConverter;

@EnableMongoRepositories(basePackages = { "com.pseudokayak.user.repository" })
public class DataConfig extends AbstractMongoConfiguration {
	@Inject
	private Environment env;

	final List<Converter<?, ?>> converters = new ArrayList<>();

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(env.getRequiredProperty("spring.data.mongodb.host"),
				env.getRequiredProperty("spring.data.mongodb.port", Integer.class));
	}

	@Override
	protected String getDatabaseName() {
		return env.getRequiredProperty("spring.data.mongodb.database");
	}

	@Override
	public MongoCustomConversions customConversions() {
		converters.add(new UserWriterConverter());
		converters.add(new UserReaderConverter());
		return new MongoCustomConversions(converters);
	}
}
