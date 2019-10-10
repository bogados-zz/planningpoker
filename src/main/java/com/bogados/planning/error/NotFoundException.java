package com.bogados.planning.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException {
	public NotFoundException(String message, String[] messageArgs, String details, String[] detailsArgs, String statusCode) {
		super(message, messageArgs, details, detailsArgs, statusCode, HttpStatus.NOT_FOUND);
	}
}
