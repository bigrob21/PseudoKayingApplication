package com.pseudokayaking.jwt.factory;

import java.time.LocalDateTime;

//https://github.com/jwtk/jjwt#jws-key-create-asym
//https://www.baeldung.com/java-json-web-tokens-jjwt

public abstract class JWTFactory <T extends java.io.Serializable> {
	
	public abstract String generateJwt(T primarySubject, long expirationTime);
	public abstract T parseJwt(String jwt);
	
	public LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}
	
	//TODO: calculate expiration lapse if so throw an exception!
	
}