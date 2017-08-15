package com.syeedode.effectivejava.generics;

import com.syeedode.effectivejava.generics.genericmethods.UnaryFunction;

/**
 * Effective Java
 * Generics -> Item 27: Favor Generic Methods
 * <p>
 * Author: syeedode
 * Date: 7/10/17
 */
public class GenericSingletonMain {

    private static UnaryFunction<Object> IDENTIY_FUNCTION =
            new UnaryFunction<Object>() {
                public Object apply(Object arg) {
                    return arg;
                }
            };

    public static void main(String [] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for(String string : strings)
            System.out.println(sameString.apply(string));

        System.out.println();

        Number[] numbers = {1, 2, 3, 4};
        UnaryFunction<Number> sameNumber = identityFunction();
        for(Number number : numbers)
            System.out.println(sameNumber.apply(number));
    }

    // IDENTITY_FUNCTION is stateless and its type parameter
    // is unbounded so it's safe to share one instance
    // across all types.
    @SuppressWarnings("unchecked")
    public static <U> UnaryFunction<U> identityFunction() {
        return (UnaryFunction<U>) IDENTIY_FUNCTION;
    }
}
