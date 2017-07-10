package com.syeedode.javaconcurrencyinpractice;

import com.syeedode.javaconcurrencyinpractice.barrier.CellularAutomata;

/**
 * Java Concurrency in Practice
 * <p>
 * Author: syeedode
 * Date: 6/23/17
 */
public class Chapter5Main {
    public static void main() {
        CellularAutomata game = CellularAutomata.getGameWithBoardInitialized();
        game.start();
    }
}
