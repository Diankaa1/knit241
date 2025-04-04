package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task8.Car;
import org.knit.solutions.ClassesTask.Task8.TrafficLight;
import org.knit.solutions.ClassesTask.Task8.TrafficLightController;

/**
 * Описание:
 * На перекрестке светофор управляет движением:
 *
 * Красный свет – машины стоят (wait()).
 * Зеленый свет – машины едут (notifyAll()).
 * Светофор переключается каждые 5 секунд.
 * Что нужно реализовать?
 * Поток "Светофор" изменяет цвет и отправляет notifyAll().
 * Потоки "Машина" ждут wait(), если красный свет.
 */
@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task8 implements Solution {
    @Override
    public void execute() {
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightController controller = new TrafficLightController(trafficLight);
        controller.start();

        for (int i = 1; i <= 5; i++) {
            new Car(i, trafficLight).start();
        }
    }
}
