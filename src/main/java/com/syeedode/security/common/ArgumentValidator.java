package com.syeedode.security.common;

import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * O'Reilly Java Security Second Edition
 * SSL Sessions - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class ArgumentValidator {
    public final static String OUTPUT_STRING = "Who is Sylvia?";

    public static String fromStringArray(String[] args, final int index, String defaultString) {
        return Optional
                .ofNullable(ObjectUtils.isEmpty(args) ? null : args)
                .map(array -> array[index])
                .orElse(defaultString);
    }
}
