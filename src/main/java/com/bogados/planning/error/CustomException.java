package com.bogados.planning.error;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
	private String message;
	private String[] messageArgs;
	private String details;
	private String[] detailsArgs;
	private String statusCode;
	private HttpStatus httpStatus;

	public CustomException(String message, String[] messageArgs, String details, String[] detailsArgs, String statusCode, HttpStatus httpStatus) {
		this.message = message;
		this.messageArgs = messageArgs;
		this.details = details;
		this.detailsArgs = detailsArgs;
		this.statusCode = statusCode;
		this.httpStatus = httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String[] getDetailsArgs() {
		return detailsArgs;
	}

	public void setDetailsArgs(String[] detailsArgs) {
		this.detailsArgs = detailsArgs;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
