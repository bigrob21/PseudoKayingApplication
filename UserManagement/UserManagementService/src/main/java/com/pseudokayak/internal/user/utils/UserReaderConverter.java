package com.pseudokayak.internal.user.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pseudokayak.internal.user.InternalUser;

public class UserReaderConverter implements Converter<Document, InternalUser> {

	@Override
	public InternalUser convert(Document source) {
		// TODO Auto-generated method stub
		return null;
	}

}
