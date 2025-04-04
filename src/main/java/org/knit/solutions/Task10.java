package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task10.Runner;

import java.util.concurrent.*;

/**
 * Описание
 * Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте. Как только все участники будут готовы, забег начнётся одновременно. Используйте CyclicBarrier, чтобы синхронизировать запуск гонки.
 *
 * Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep), после чего финиширует. Как только все бегуны завершат дистанцию, программа выводит сообщение о завершении гонки.
 *
 * Требования к задаче:
 * Создать CyclicBarrier для синхронизации начала забега.
 * Реализовать класс Runner, который будет выполнять следующую логику в потоке:
 * Ожидание старта (использование barrier.await()).
 * Симуляция бега (Thread.sleep(randomTime)).
 * Вывод сообщения о финише.
 * После финиша всех участников программа должна сообщить, что гонка завершена.
 * Количество бегунов передаётся в аргументах командной строки или задаётся константой.
 * Подсказка
 * Используйте Executors.newFixedThreadPool() для управления потоками.
 * Для генерации случайного времени забега можно использовать ThreadLocalRandom.current().nextInt(500, 3000).
 */
@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task10 implements Solution {
    @Override
    public void execute() {
        CyclicBarrier barrier = new CyclicBarrier(5, () ->
                System.out.println("Стартуем!"));

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            executor.submit(new Runner(barrier, i));



        }

        executor.shutdown();
    }
}

