package com.syeedode.effectivejava.generics.genericmethods;

/**
 * Effective Java
 * Generics -> Item 27: Favor Generic Methods
 * <p>
 * Author: syeedode
 * Date: 7/10/17
 */
public interface UnaryFunction<T> {
    T apply(T arg);
}
