package com.pseudokayak.user.configs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.pseudokayak.user.model.User;
import com.pseudokayak.user.repository.UserRepository;

@SpringBootApplication
@Import({ServiceConfig.class, WebConfig.class})
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(@Autowired UserRepository repository) {
			//Only populate or seed if no users are present!
			return (args) -> {
				if(repository.findAll().isEmpty()) {
					List<String> roleList1 = Stream.of("ADMIN", "USER")
						.map(Object::toString).collect(Collectors.toList());
					User user1 = User.builder()
						.userId("robert-0")
						.firstName("Robert0")
						.lastName("Foobar")
						.roles(roleList1)
						.build();
					repository.save(user1);
				}
		};
	}
	
}
