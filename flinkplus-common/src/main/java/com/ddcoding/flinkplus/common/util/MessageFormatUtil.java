package com.ddcoding.flinkplus.common.util;

import java.text.MessageFormat;

/**
 * @author: ddcoding
 * @date: 2020/8/24
 */
public class MessageFormatUtil {
    public static String format(String pattern, Object... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i] instanceof Number) {
                arguments[i] = String.valueOf(arguments[i]);
            }
        }
        return MessageFormat.format(pattern, arguments);
    }
}
