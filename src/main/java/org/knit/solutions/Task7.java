package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task7.Consumer;
import org.knit.solutions.ClassesTask.Task7.Producer;
import org.knit.solutions.ClassesTask.Task7.Warehouse;

/**
 * Описание:
 *
 * Производитель создает товары (максимум 5).
 * Потребитель забирает товары.
 * Если товаров нет, потребитель ждет (wait()).
 * Если товаров максимум, производитель ждет (wait()).
 * Что нужно реализовать?
 * wait() – если товаров нет или склад заполнен.
 * notify() – пробуждение потока, когда изменяется состояние склада.
 */
@TaskDescription(taskNumber = 7, taskDescription = "Задача «Производитель-Потребитель с ограничением»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task7 implements Solution {
    @Override
    public void execute() {
        // Создаем общий склад
        Warehouse warehouse = new Warehouse();

        // Создаем и запускаем поток производителя
        Thread producerThread = new Thread(new Producer(warehouse));
        producerThread.start();

        // Создаем и запускаем поток потребителя
        Thread consumerThread = new Thread(new Consumer(warehouse));
        consumerThread.start();

        try {
            Thread.sleep(30000); // 30 секунд

            // Завершаем программу
            producerThread.interrupt();
            consumerThread.interrupt();

            // Ждем завершения потоков
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
