package com.syeedode.effectivejava.generics;

import com.syeedode.effectivejava.generics.wildcardgenerics.Unionizer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Effective Java
 * Generics -> Item 28: Use Bounded Wilcards
 * <p>
 * Author: syeedode
 * Date: 7/10/17
 */
public class GenericUnionMain {
    public static void main(String [] args) {
        Unionizer service = new Unionizer();
        Integer[] ints = {3, 4, 5};
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(ints));
        Integer[] intsAsWell = {6, 4, 5};
        Set<Integer> integerSetToo = new HashSet<>(Arrays.asList(ints));
        Set<Integer> result = service.union(integerSet, integerSetToo);
        System.out.println(result);

        Double[] nums = {8.0, 9.0, 10.0};
        Set<Double> doubleSet = new HashSet<>(Arrays.asList(nums));
        System.out.println(service.<Number>myUnion(result,doubleSet));
    }
}
