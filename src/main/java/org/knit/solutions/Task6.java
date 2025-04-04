package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task6.RailwayCrossing;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Описание:
 * Есть автомобили и поезд.
 *
 * Если поезд приближается, машины останавливаются и ждут.
 * После того, как поезд проедет, машины продолжают движение.
 * Что нужно реализовать?
 * Поток "Поезд" останавливает автомобили (wait()).
 * Поток "Поезд" сообщает о завершении (notifyAll()).
 * Машины ждут, если поезд едет, и продолжают движение после notifyAll().
 */
@TaskDescription(taskNumber = 6, taskDescription = "Задача «Железнодорожный переезд»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task6 implements Solution {
    @Override
    public void execute() {
        RailwayCrossing crossing = new RailwayCrossing();

        Thread train = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 7001));
                    crossing.trainArrives();

                    Thread.sleep(5000);
                    crossing.trainDeparts();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поезд остановлен");
            }
        });

        // Машины
        Thread[] cars = new Thread[5];
        for (int i = 0; i < cars.length; i++) {
            int carId = i + 1;
            cars[i] = new Thread(() -> {
                try {
                    while (true) {
                        crossing.carArrives(carId);

                        Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 6000));
                        System.out.println("Машина " + carId + " вернулась к переезду");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Машина " + carId + " остановлена");
                }
            });
            cars[i].start();
        }

        train.start();
    }
}
