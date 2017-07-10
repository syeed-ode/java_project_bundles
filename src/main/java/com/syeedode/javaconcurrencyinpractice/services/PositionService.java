package com.syeedode.javaconcurrencyinpractice.services;

/**
 * Java Concurrency in Practice
 * <p>
 * Author: syeedode
 * Date: 6/23/17
 */
public class PositionService {
    public final int getPositionAtCoordinates(int x, int y) {
        Long value = Math.round(Math.sqrt(x^2 + y^2));
        return value.intValue();
    }
}
