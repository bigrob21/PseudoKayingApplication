package com.pseudokayaking.app.jwt;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.pseudokayak.user.model.User;
import com.pseudokayaking.jwt.factory.JWTFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UserJWTTokenFactory extends JWTFactory<User> {

	static final String APPLICATION_NAME="PSEUDO-KAYAKING";
	
	private String secretKey;
	private SignatureAlgorithm sigAlgorithm;
	
	public UserJWTTokenFactory(String key, SignatureAlgorithm algo){
		if(key == null || key.trim().isEmpty()) {
			throw new IllegalArgumentException("The JWT Generator " + this.getClass().getName() + " must get assigned a secret key "
					+ "to secure tokens!");
		}
		if(algo == null) {
			throw new IllegalArgumentException("A signature Algorithm must be selected");
		}
		this.secretKey = key;
		this.sigAlgorithm = algo;
	}
	
	@Override
	public String generateJwt(User primarySubject, long expirationTime) {
		Map<String, Object> claims = new HashMap<>();
		claims.putIfAbsent("sub", primarySubject);
		LocalDateTime now = getCurrentDateTime();
		return Jwts.builder()
			.setId(UUID.randomUUID().toString())
			.setNotBefore(Timestamp.valueOf(now))
			.setIssuedAt(Timestamp.valueOf(now))
			.setExpiration(Timestamp.valueOf(now.plusSeconds(expirationTime)))
			.claim("user", primarySubject)
			.setIssuer(APPLICATION_NAME)
			.signWith(this.sigAlgorithm, this.secretKey)
			.setSubject(primarySubject.getUserId())
			.compact();
	}

	@Override
	public User parseJwt(String jwt) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//TODO: Delete this as this is a simple harness to test usage!!
	public static void main(String[] args) {
		UserJWTTokenFactory factory = new UserJWTTokenFactory("ABbrACADABR@", SignatureAlgorithm.HS384);
		User uzer = User.builder().firstName("Donald")
			.lastName("Duck")
			.userId(UUID.randomUUID().toString())
			.userName("DDUCK")
			.roles(Arrays.asList("Role-1", "Role-2"))
			.build();
		System.out.println(factory.generateJwt(uzer , 300000L));
	}

}
