package com.pseudokayaking.jwt.validation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTExpirationException extends RuntimeException {
	private static final long serialVersionUID = 4790494369734314899L;
	private String errorMessage;
}