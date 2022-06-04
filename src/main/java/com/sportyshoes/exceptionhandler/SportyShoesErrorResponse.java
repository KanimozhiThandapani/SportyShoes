package com.sportyshoes.exceptionhandler;

public class SportyShoesErrorResponse {
	private int statusCode;
	private String message;
	private long timeStamp;

	public SportyShoesErrorResponse() {}

	public SportyShoesErrorResponse(int statusCode, String message, long timeStamp) {
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}