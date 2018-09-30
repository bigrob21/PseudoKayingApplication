package com.pseudokayaking.app.jwt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	public void test1() {
		System.out.println(OUTDATED_JWT_STRING);
	}
}
