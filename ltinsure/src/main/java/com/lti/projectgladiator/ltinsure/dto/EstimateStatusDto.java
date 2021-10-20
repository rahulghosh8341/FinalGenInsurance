package com.lti.projectgladiator.ltinsure.dto;

import org.springframework.web.bind.annotation.ResponseStatus;

public class EstimateStatusDto {

	private String message;
	private StatusType status;
	private double estimateAmount;
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

	public double getEstimateAmount() {
		return estimateAmount;
	}

	public void setEstimateAmount(double estimateAmount) {
		this.estimateAmount = estimateAmount;
	}

	public static enum StatusType {
		SUCCESS, FAILURE;
	}

}