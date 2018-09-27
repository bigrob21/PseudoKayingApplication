package com.pseudokayaking.jwt.factory;

//https://github.com/jwtk/jjwt#jws-key-create-asym
//https://www.baeldung.com/java-json-web-tokens-jjwt

public interface JWTFactory <T extends java.io.Serializable> {
	public <T extends java.io.Serializable> T instance();
}