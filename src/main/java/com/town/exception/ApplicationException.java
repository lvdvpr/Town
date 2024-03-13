package com.town.exception;

import java.io.Serial;

public class ApplicationException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -5204036240037233476L;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
