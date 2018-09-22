package com.pseudokayak.internal.user.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pseudokayak.internal.user.InternalUser;

public class UserWriterConverter implements Converter<InternalUser, Document> {

	@Override
	public Document convert(InternalUser source) {
		// TODO Auto-generated method stub
		return null;
	}

}
