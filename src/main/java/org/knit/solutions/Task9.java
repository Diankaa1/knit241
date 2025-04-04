package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task9.Assembler;
import org.knit.solutions.ClassesTask.Task9.Detail;
import org.knit.solutions.ClassesTask.Task9.QualityControl;
import org.knit.solutions.ClassesTask.Task9.Stamper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Описание задачи
 * На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
 *
 * Штамповщик – вырезает заготовку (создает объект детали).
 * Сборщик – собирает из заготовки готовую деталь.
 * Оператор контроля качества – проверяет деталь и отправляет на склад.
 * Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
 *
 * Требования к решению
 * Использовать потоки (Thread или ExecutorService).
 * Использовать синхронизацию (wait(), notify(), BlockingQueue).
 * Реализовать конвейерную передачу данных между потоками.
 */
@TaskDescription(taskNumber = 9, taskDescription = "Задача «Конвейер сборки деталей»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task9 implements Solution {
    @Override
    public void execute() {
        BlockingQueue<Detail> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> queue2 = new LinkedBlockingQueue<>();

        Stamper stamper = new Stamper(queue1);
        Assembler assembler = new Assembler(queue1, queue2);
        QualityControl qualityControl = new QualityControl(queue2);

        stamper.start();
        assembler.start();
        qualityControl.start();
    }
}