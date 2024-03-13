package com.town.exception;

import java.io.Serial;

public class AlreadyRegisteredUserIdException extends ApplicationException {

	@Serial
	private static final long serialVersionUID = 869066890260990941L;

	public AlreadyRegisteredUserIdException(String message) {
		super(message);
	}

    public AlreadyRegisteredUserIdException(String message, Throwable cause) {
        super(message, cause);
    }

}
