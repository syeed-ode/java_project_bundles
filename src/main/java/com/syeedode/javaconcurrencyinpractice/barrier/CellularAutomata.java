package com.syeedode.javaconcurrencyinpractice.barrier;

import com.syeedode.javaconcurrencyinpractice.services.PositionService;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Java Concurrency in Practice
 * <p>
 * Author: syeedode
 * Date: 6/23/17
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;
    private final PositionService positionService;

    private CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, () -> mainBoard.commitNewValues());
        this.workers = new Worker[count];
        buildIndivdiualWorkers(count);
        positionService = new PositionService();
    }

    public static CellularAutomata getGameWithBoardInitialized() {
        Board b = Board.getMasterGameBoard();
        return new CellularAutomata(b);
    }

    private void buildIndivdiualWorkers(int subWorkersCount) {
        for(int count = 0; count < subWorkersCount; count++){
            workers[count] = new Worker(mainBoard.getSubBoard(count), count, mainBoard);
        }
    }

    public class Worker implements Runnable {
        private final Board board;
        private final String workerId;
        public final Object lock;

        public Worker(Board board, int id, Object mainLock) {
            lock = mainLock;
            StringBuffer stringBuffer = new StringBuffer("WorkerId_");
            stringBuffer.append(id);
            workerId = stringBuffer.toString();
            this.board = board;
        }

        public void run() {
            while(!board.hasConverged()){
                for(int x = 0; x < board.getMaxX(); x++) {
                    for(int y = 0; y < board.getMaxY(); y++) {
                        synchronized (mainBoard) {
                            int positionAtCoordinates = positionService.getPositionAtCoordinates(x, y);
                            board.setNewValue(x, y, positionAtCoordinates, this);
                            mainBoard.setMainBoardPostionsPostion(board.getBoardPostion(), this);
                        }
                    }
                }
                try {
                    barrier.await();
                    System.out.println("Completed barrier await: " + printStatus(this, mainBoard));
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
                System.out.print("Completed TheGame");
            }
        }

        public String getId() {
            return this.workerId;
        }
    }

    private String printStatus(Worker worker, Board mainBoard) {
        return mainBoard.printTotalStatus(worker);
    }

    public void start() {
        for(int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }
}
