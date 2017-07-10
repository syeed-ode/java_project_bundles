package com.syeedode.javaconcurrencyinpractice.barrier;

import com.syeedode.javaconcurrencyinpractice.services.PositionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

/**
 * Java Concurrency in Practice
 * <p>
 * Author: syeedode
 * Date: 6/23/17
 */
public class Board {

    private final PositionService positionService;
    private final Map<String, List<Integer>> gamePostions = new HashMap<>();

    private AtomicInteger boardPostion = new AtomicInteger(0);
    private AtomicInteger subBoardPosition = new AtomicInteger(0);

    private Board() {
        positionService = new PositionService();
    }

    public static Board getMasterGameBoard() {
        return new Board();
    }

    public void commitNewValues() {
        System.out.println("Storing new subBoardPosition: " + subBoardPosition.get());
    }

    public Board getSubBoard(int boardId) {
        return new SubBoard(boardId);
    }

    public boolean hasConverged() {
        try {
            double random = Math.random();
            double waitTime = random * 3 * 1000;
            Thread.sleep(Math.round(waitTime));
        } catch (InterruptedException e) {
            System.out.println("Encountered an exception " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int getMaxX() {
        return 1;
    }

    public int getMaxY() {
        return 1;
    }

    public final void waitForConvergence() {
        System.out.println("Wating for convergence of the main board only");
    }

    public void setMainBoardPostionsPostion(int value, CellularAutomata.Worker worker) {
        if(gamePostions.containsKey(worker.getId())){
            List<Integer> positions = gamePostions.get(worker.getId());
            positions.add(value);
            gamePostions.put(worker.getId(),positions);
            System.out.print(worker.getId()
                    + " added "
                    + value
                    + " to list: "
                    + positions
                        .stream()
                        .map(p -> valueOf(p))
                        .collect(joining(",")));
        } else {
            List<Integer> positions = new ArrayList<>();
            positions.add(value);
            gamePostions.put(worker.getId(), positions);
            System.out.println(worker.getId() + " added " + value + " to empty collection);");
        }
    }

    public String printTotalStatus(CellularAutomata.Worker worker) {
/*
        System.out.print(worker.getId()
                + " added "
                + value
                + " to list: "
                + positions
                .stream()
                .map(p -> valueOf(p))
                .collect(joining(",")));
*/

        return null;
    }

    private class SubBoard extends Board {
        private final String id;
        public SubBoard(int boardId) {
            super();
            id = valueOf(boardId);
        }
    }

    public int getBoardPostion() {
        return boardPostion.get();
    }

    public void setNewValue(int x, int y, int newPosition, CellularAutomata.Worker w) {
        System.out.print("Worker: " + w.getId() + " added " + newPosition + " to board pos: " + boardPostion.get());
        int newValue = boardPostion.get() + newPosition;
        boardPostion.set(newValue);
        System.out.println(" which yielded new boardPosition: " + boardPostion.get() + " for "
                + w.getId() + " x, y ignored x: " + x  + " y: " + y );
    }
}
