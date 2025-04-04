package org.knit.solutions.ClassesTask.Task4;


import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class GasStation {
    private final Semaphore semaphore;

    public GasStation(int totalColumns) {
        this.semaphore = new Semaphore(totalColumns, true);
    }

    public void refuel(String carName) {
        try {
            System.out.println(carName + " ожидает заправку...");
            semaphore.acquire();  // Запрашиваем доступ к колонке
            System.out.println(carName + " заправляется...");

            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));  // Симуляция заправки;

            System.out.println(carName + " Завершил заправку и уезжает.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
