package com.ddcoding.flinkplus.model.exception;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
public class ValidationException extends PlinkRuntimeException {
    private static final long serialVersionUID = -1L;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

}
