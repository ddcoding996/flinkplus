package com.ddcoding.flinkplus.model.exception;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
public class FlinkPlusMessageException extends FlinkPlusRuntimeException {
    private static final long serialVersionUID = -1L;

    public FlinkPlusMessageException(String message) {
        super(message);
    }

}
