package com.lti.projectgladiator.ltinsure.exception;


public class UserServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException() {
		super();
	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}
}
