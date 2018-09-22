package com.pseudokayak.user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 5574475787502229452L;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String userId;
	
	@Builder.Default 
	private List<String> roles = new ArrayList<>();
	
}
