package com.codematrix.flight.exceptions;

public class ValidationException extends ApiException {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param errorCode
     * @param errorMessage
     */
    public ValidationException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
