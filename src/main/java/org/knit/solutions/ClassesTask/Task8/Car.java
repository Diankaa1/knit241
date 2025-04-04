package org.knit.solutions.ClassesTask.Task8;

public class Car extends Thread {
    private final TrafficLight trafficLight;
    private final int carId;

    public Car(int carId, TrafficLight trafficLight) {
        this.carId = carId;
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        while (true) {
            trafficLight.waitForGreen();
            System.out.println("Машина " + carId + " поехала.");
            try {
                Thread.sleep(1000); // Машина едет 1 секунду
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

