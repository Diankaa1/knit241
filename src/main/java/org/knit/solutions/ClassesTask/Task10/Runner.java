package org.knit.solutions.ClassesTask.Task10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final CyclicBarrier barrier;
    private final int runnerId;

    public Runner(CyclicBarrier barrier, int runnerId) {
        this.barrier = barrier;
        this.runnerId = runnerId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + runnerId + " готовится к старту.");
            barrier.await();

            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            System.out.println("Бегун " + runnerId + " стартовал и будет бежать " + runTime + " мс.");
            Thread.sleep(runTime);
            System.out.println("Бегун " + runnerId + " финишировал!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
