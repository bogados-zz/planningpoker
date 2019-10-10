package com.bogados.planning.error;

public class UserNotFoundException extends NotFoundException {
	public UserNotFoundException() {
		super("", new String[]{""}, "", new String[]{""}, "4041");
	}
}
