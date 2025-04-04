package org.knit.solutions.ClassesTask.Task9;

import java.util.concurrent.BlockingQueue;

public class QualityControl extends Thread {
    private final BlockingQueue<Detail> queue;

    public QualityControl(BlockingQueue<Detail> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Detail detail = queue.take();  // Берем собранную деталь
                System.out.println("Оператор контроля: Деталь " + detail.getId() + " проверена и отправлена на склад");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
