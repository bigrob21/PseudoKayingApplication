package com.pseudokayak.user.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ServiceConfig.class, WebConfig.class})
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner loadData(@Autowired UserRepository repository) {
		return (args) -> {
			User user1 = User.builder()
					.firstName("Robert0")
					.lastName("Foobar")
					.build();
			repository.save(user1);
		};
	}*/
	
}
