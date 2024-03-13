package com.town.exception;

import java.io.Serial;

public class AlreadyRegisteredEmailException extends ApplicationException{

	@Serial
	private static final long serialVersionUID = -4963640903481590492L;

	public AlreadyRegisteredEmailException(String message) {
        super(message);
    }

    public AlreadyRegisteredEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
