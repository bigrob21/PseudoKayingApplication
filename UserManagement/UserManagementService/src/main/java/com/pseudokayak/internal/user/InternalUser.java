package com.pseudokayak.internal.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Internal represenation of a User Object. Note we should not use this object outside the context of simply 
 * maintaining Security User State of this singluar app context (User Management)!
 * 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternalUser implements UserDetails {
	private static final long serialVersionUID = 4948521899302497636L;
	
	@Builder.Default List<? extends GrantedAuthority> authorities = new ArrayList<>();
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean enabled;
	
}
