package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task4.Car;
import org.knit.solutions.ClassesTask.Task4.GasStation;

/**
 * Описание:
 * На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
 * Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.
 *
 * Что нужно реализовать?
 * Использовать wait() и notify() для ожидания и освобождения заправки.
 * Поток "Машина" ждет, если все колонки заняты.
 * Поток "Машина" заправляется, затем освобождает колонку.
 */
@TaskDescription(taskNumber = 4, taskDescription = "Задача «Автозаправочная станция»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task4 implements Solution {
    @Override
    public void execute() {
        int gasColumns = 2;

        GasStation station = new GasStation(gasColumns);

        for (int i = 1; i <= 5; i++) {
            new Car(station, "Машина " + i).start();
        }
    }
}
