package com.pseudokayak.user.configs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.pseudokayak.internal.user.InternalUser;
import com.pseudokayak.user.repository.UserRepository;

@SpringBootApplication
@Import({ServiceConfig.class, WebConfig.class})
@EnableAutoConfiguration(exclude= {SecurityAutoConfiguration.class})
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(@Autowired UserRepository repository) {
			//Only populate or seed if no users are present!
			return (args) -> {
				if(repository.findAll().isEmpty()) {
					List<? extends GrantedAuthority> roleList1 = Stream.of("ADMIN", "USER")
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
					InternalUser user1 = InternalUser.builder()
						.username("Luke Skywalker")
						.firstName("Luke")
						.lastName("Skywalker")
						.username("lskywalker")
						.authorities(roleList1)
						.build();
					repository.save(user1);
				}
		};
	}
	
}
