package org.knit.solutions.ClassesTask.Task6;

public class RailwayCrossing {
    private boolean trainComing = false;

    // Поезд приближается
    public synchronized void trainArrives() {
        System.out.println("Поезд приближается! Машины должны остановиться.");
        trainComing = true;
    }

    // Поезд уехал
    public synchronized void trainDeparts() {
        System.out.println("Поезд проехал! Машины могут продолжить движение.");
        trainComing = false;
        notifyAll(); // Будим все ожидающие машины
    }

    // Машина пытается проехать
    public synchronized void carArrives(int carId) {
        while (trainComing) {
            try {
                System.out.println("Машина " + carId + " ждет, пока поезд проедет.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Машина " + carId + " проехала переезд.");
    }
}
