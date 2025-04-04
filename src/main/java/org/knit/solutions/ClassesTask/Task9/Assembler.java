package org.knit.solutions.ClassesTask.Task9;

import java.util.concurrent.BlockingQueue;

public class Assembler extends Thread {
    private final BlockingQueue<Detail> inputQueue;
    private final BlockingQueue<Detail> outputQueue;

    public Assembler(BlockingQueue<Detail> inputQueue, BlockingQueue<Detail> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Detail detail = inputQueue.take();  // Берем заготовку
                System.out.println("Сборщик: Заготовка " + detail.getId() + " обработана");
                outputQueue.put(detail);  // Передаем дальше на контроль качества
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
