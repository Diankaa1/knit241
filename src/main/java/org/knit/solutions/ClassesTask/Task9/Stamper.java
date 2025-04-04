package org.knit.solutions.ClassesTask.Task9;

import java.util.concurrent.BlockingQueue;

public class Stamper extends Thread {
    private final BlockingQueue<Detail> queue;
    private int count = 1;

    public Stamper(BlockingQueue<Detail> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Detail detail = new Detail(count++);
                System.out.println("Штамповщик: Заготовка " + detail.getId() + " создана");
                queue.put(detail);  // Передаем заготовку в очередь, чтобы передать сборщику
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}