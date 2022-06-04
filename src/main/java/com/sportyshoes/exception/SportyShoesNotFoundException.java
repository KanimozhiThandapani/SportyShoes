package com.sportyshoes.exception;

public class SportyShoesNotFoundException extends RuntimeException {
	public SportyShoesNotFoundException() {
	}

	public SportyShoesNotFoundException(String message) {
		super(message);

	}

	public SportyShoesNotFoundException(Throwable cause) {
		super(cause);
	}

	public SportyShoesNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public SportyShoesNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}