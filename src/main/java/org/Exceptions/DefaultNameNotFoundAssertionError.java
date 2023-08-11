package org.Exceptions;

public class DefaultNameNotFoundAssertionError extends AssertionError {
    public static final String INVALID_NAME = "The alert text doesn't contains the value expected";

    public DefaultNameNotFoundAssertionError(String message, Throwable cause) {
        super(message, cause);
    }

}
