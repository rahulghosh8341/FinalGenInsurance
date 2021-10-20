package com.lti.projectgladiator.ltinsure.exception;

public class RenewServiceException extends RuntimeException{
	//constructors from superclass
		public RenewServiceException() {
			super();
		
		}

		public RenewServiceException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public RenewServiceException(String message, Throwable cause) {
			super(message, cause);
			
		}

		public RenewServiceException(String message) {
			super(message);
			
		}

		public RenewServiceException(Throwable cause) {
			super(cause);
			
		}

	}
