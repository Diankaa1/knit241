package org.knit.solutions.ClassesTask.Task7;

public class Producer implements Runnable {
    private final Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                warehouse.produce();

                // Время на производство нового товара
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
