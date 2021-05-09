package com.ddcoding.flinkplus.model.exception;

/**
 * @author: ddcoding
 * @date: 2020/2/17
 */
public class FlinkPlusException extends Exception {
    private static final long serialVersionUID = -1L;

    public FlinkPlusException() {
    }

    public FlinkPlusException(String message) {
        super(message);
    }

    public FlinkPlusException(String message, Throwable cause) {
        super(message + ":" + cause.getMessage(), cause);
    }

    public FlinkPlusException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}