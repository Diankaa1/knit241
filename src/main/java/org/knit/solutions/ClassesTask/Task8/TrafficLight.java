package org.knit.solutions.ClassesTask.Task8;

public class TrafficLight {
    private boolean isGreen = false;

    public synchronized void waitForGreen() {
        while (!isGreen) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void switchLight() {
        isGreen = !isGreen;
        System.out.println(isGreen ? "Светофор: Зелёный! Машины едут." : "Светофор: Красный! Машины стоят.");
        notifyAll();
    }
}
