package com.clean.code.domain.usecase.expection;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 2254624415019700577L;

	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
