package com.pseudokayak.user.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 5574475787502229452L;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String userId;
	
	private List<String> roles = new ArrayList<>();
}
