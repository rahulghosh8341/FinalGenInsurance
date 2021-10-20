package com.lti.projectgladiator.ltinsure.dto;

import org.springframework.web.bind.annotation.ResponseStatus;

public class StatusDto {

	private String message;
	private StatusType status;
	private ResponseStatus statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public ResponseStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(ResponseStatus statusCode) {
		this.statusCode = statusCode;
	}

	public static enum StatusType {
		SUCCESS, FAILURE;
	}

}