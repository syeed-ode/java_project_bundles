package com.syeedode.authservices;

import com.syeedode.authservices.arrays.ArrayUniqStrCalculator;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 192; Problem 1.1
 *
 */
public class ArrayMainClass {

    public static void main(String [] args) {
        System.out.println(
                ArrayUniqStrCalculator
                        .reverseString("hey you smoothie"));

        System.out.println("\n\n\n\n\n");

        System.out.println(
                ArrayUniqStrCalculator
                        .calculateUniqString("hey you smoothie"));
    }

}
