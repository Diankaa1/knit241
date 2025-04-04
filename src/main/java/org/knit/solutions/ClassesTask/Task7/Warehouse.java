package org.knit.solutions.ClassesTask.Task7;

public class Warehouse {
    private int itemCount = 0;
    private static final int MAX_ITEMS = 5;

    // Производитель добавляет товар
    public synchronized void produce() throws InterruptedException {
        while (itemCount >= MAX_ITEMS) {
            System.out.println("Склад полон. Производитель ждет...");
            wait();
        }

        // Добавляем товар
        itemCount++;
        System.out.println("Производитель добавил товар. Товаров на складе: " + itemCount);

        notify();
    }

    // Потребитель забирает товар
    public synchronized void consume() throws InterruptedException {
        while (itemCount <= 0) {
            System.out.println("Склад пуст. Потребитель ждет...");
            wait();
        }

        // Забираем товар
        itemCount--;
        System.out.println("Потребитель забрал товар. Товаров на складе: " + itemCount);

        notify();
    }
}
