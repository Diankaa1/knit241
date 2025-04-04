package org.knit.solutions.ClassesTask.Task8;

public class TrafficLightController extends Thread {
    private final TrafficLight trafficLight;

    public TrafficLightController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                trafficLight.switchLight();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
