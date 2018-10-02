package com.pseudokayaking.app.jwt;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pseudokayak.user.model.User;
import com.pseudokayaking.jwt.factory.JWTFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UserJWTTokenFactory extends JWTFactory<User> {

	public static final String APPLICATION_NAME="PSEUDO-KAYAKING";
	public static final String USER_CLAIMS_KEY = "user";
	static final ObjectMapper MAPPER = new ObjectMapper();
	
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
		LocalDateTime now = getCurrentDateTime();
		return Jwts.builder()
			.setId(UUID.randomUUID().toString())
			.setNotBefore(Timestamp.valueOf(now))
			.setIssuedAt(Timestamp.valueOf(now))
			.setExpiration(Timestamp.valueOf(now.plusSeconds(expirationTime)))
			.claim(USER_CLAIMS_KEY, primarySubject)
			.setIssuer(APPLICATION_NAME)
			.signWith(this.sigAlgorithm, this.secretKey)
			.setSubject(primarySubject.getUserId())
			.compact();
	}

	@Override
	public User parseJwt(String jwt) {
		Claims claims = Jwts
				.parser()
				.setSigningKey(this.secretKey)
				.parseClaimsJws(jwt)
				.getBody();
		return Optional.ofNullable(claims.get(USER_CLAIMS_KEY))
					.map(o -> MAPPER.convertValue(o, User.class))
					.orElseThrow(() -> new IllegalArgumentException("Unable to located user attribute from JWT, token is invalid"));		
	}

}