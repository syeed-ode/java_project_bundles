package com.syeedode.effectivejava.serialization.main;

import com.syeedode.effectivejava.serialization.period.MutablePeriod;
import com.syeedode.effectivejava.serialization.period.Period;

import java.util.Date;

/**
 * Effective Java
 * <p>
 * Author: syeedode
 * Date: 7/24/17
 */
public class SerializationMain {
    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        System.out.println("This is before we stared manipulated: " + p);

        // Let's turn back the clock
        pEnd.setYear(78);
        System.out.println("This is after we've manipulated pEnd.setYear(78);: " + p);

        // Bring back the 60s!
        pEnd.setYear(69);
        System.out.println("This is the final manipulated pEnd.setYear(69);: " + p);
    }
}
