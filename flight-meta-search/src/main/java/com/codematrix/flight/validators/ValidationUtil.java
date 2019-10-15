package com.codematrix.flight.validators;

import com.codematrix.flight.exceptions.ValidationException;

public class ValidationUtil {

    public static void assertNotNull(Object value, String errorCode, String message) throws ValidationException {
        if (value == null) {
            throw new ValidationException(errorCode, message);
        }
    }

    public static void assertEquals(Object value1, Object value2, String errorCode, String message) throws ValidationException {
        if (value1 == null && !value1.equals(value2)) {
            throw new ValidationException(errorCode, message);
        }
    }

    public static void assertNotEquals(String value1, String value2, String errorCode, String message) throws ValidationException {
        if (value1 == null || value1.equals(value2)) {
            throw new ValidationException(errorCode, message);
        }
    }
}
