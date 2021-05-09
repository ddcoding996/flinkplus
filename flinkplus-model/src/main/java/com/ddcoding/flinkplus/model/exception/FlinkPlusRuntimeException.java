package com.ddcoding.flinkplus.model.exception;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
public class FlinkPlusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -1L;

    public FlinkPlusRuntimeException() {
        super();
    }

    public FlinkPlusRuntimeException(String message) {
        super(message);
    }

    public FlinkPlusRuntimeException(String message, Throwable cause) {
        super(message + ":" + cause.getMessage(), cause);
    }

    public FlinkPlusRuntimeException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
