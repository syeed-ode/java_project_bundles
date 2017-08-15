package com.syeedode.effectivejava.generics.wildcardgenerics;

import java.util.HashSet;
import java.util.Set;

/**
 * Effective Java
 * Generics -> Item 28: Use Bounded Wilcards
 * <p>
 * Author: syeedode
 * Date: 7/10/17
 */
public class Unionizer {

    public <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public <U> Set<U> myUnion(Set<? extends U> s1, Set<? extends U> s2) {
        Set<U> result = new HashSet<U>(s1);
        result.addAll(s2);
        return result;
    }
}
