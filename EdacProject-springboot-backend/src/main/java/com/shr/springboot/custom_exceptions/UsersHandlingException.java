package com.shr.springboot.custom_exceptions;

@SuppressWarnings("serial")
public class UsersHandlingException extends RuntimeException {
public UsersHandlingException(String mesg) {
	super(mesg);
}
}
