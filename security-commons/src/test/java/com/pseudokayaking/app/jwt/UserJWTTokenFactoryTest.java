package com.pseudokayaking.app.jwt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.pseudokayak.user.model.User;

import io.jsonwebtoken.SignatureAlgorithm;

public class UserJWTTokenFactoryTest {

	private static UserJWTTokenFactory TestUnit;
	private static String OUTDATED_JWT_STRING;
	private static final String OUTDATED_JWT_FILE = "jwt1.txt";
	private static final String SECRET_KEY_VALUE = "foobar";
	private static final SignatureAlgorithm SIG_ALGO = SignatureAlgorithm.HS256;
	
	@BeforeAll
	public static void initializeTestCase() {
		TestUnit = new UserJWTTokenFactory(SECRET_KEY_VALUE, SIG_ALGO);
		Path filePath = null;
		Stream<String> lines = null;
		try {
			filePath = Paths
					.get(UserJWTTokenFactoryTest.class.getClassLoader()
							.getResource(OUTDATED_JWT_FILE).toURI());
			lines = Files.lines(filePath);
			OUTDATED_JWT_STRING = lines.collect(Collectors.joining("\n"));
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}finally {
			if(lines != null) {
				lines.close();
			}
		}
	}

	@Test
	public void testNormalTokenCreation() {
		LocalDateTime ldt = LocalDateTime.now();
		//TODO: Need to validate the timeout of this token, TBD.
		LocalDateTime nowPlus5Mins = ldt.plusMinutes(5);
		User testUser = generateTestUser();
		final String jwtString = TestUnit.generateJwt(testUser, 40000L);
		assertNotNull(jwtString);
		assertTrue(jwtString.trim().length() > 100);
		System.out.println(String.format("Generated JWT:  %s" ,new Object[] {jwtString}) );
	}
	
	@Test
	public void testJwtParseExpiredJwt() {
		AtomicReference<User> uzerClaim = new AtomicReference<>();
		assertThrows(io.jsonwebtoken.ExpiredJwtException.class, () -> {
			uzerClaim.set(TestUnit.parseJwt(OUTDATED_JWT_STRING));
		});
	}
	
	private User generateTestUser() {
		return User.builder().firstName("Donald")
			.lastName("Duck")
			.userId(UUID.randomUUID().toString())
			.userName("DDUCK")
			.roles(Arrays.asList("Role-1", "Role-2"))
			.build();
	}
	
}
