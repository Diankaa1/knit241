package org.knit.solutions.ClassesTask.Task7;

public class Consumer implements Runnable {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Потребляем товар
                warehouse.consume();

                // Время на потребление товара
                Thread.sleep((long) (Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
