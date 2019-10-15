package com.codematrix.flight.exceptions;

public class ApiException extends Exception {

    private String errorCode;
    private String errorMessage;


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param errorMessage the detail message. The detail message is saved for
     *                     later retrieval by the {@link #getMessage()} method.
     */
    public ApiException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
