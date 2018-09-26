package com.psuedokayak.user.dtos;

import java.util.Optional;
import static java.util.stream.Collectors.toList;

import javax.validation.constraints.NotNull;

import com.pseudokayak.internal.user.InternalUser;
import com.pseudokayak.user.model.User;

public class UserConverterUtils {

	public static User convertInternalUserToUser(@NotNull InternalUser user) {
		User.UserBuilder builder = User.builder();
		Optional.ofNullable(user.getFirstName()).ifPresent(name -> builder.firstName(name));
		Optional.ofNullable(user.getLastName()).ifPresent(name -> builder.lastName(name));
		builder.roles(user.getAuthorities().stream().map(role -> role.getAuthority()).collect(toList()));
		builder.userName(user.getUsername());
		return builder.build();
	}
	
	//Omitting conversion from Input User to Internal User. 
	
}
