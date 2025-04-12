package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task11.EmailNotifier;
import org.knit.solutions.ClassesTask.Task11.MobileApp;
import org.knit.solutions.ClassesTask.Task11.Stock;

/**
 * Задача 11: Реализация системы уведомлений в биржевом приложении
 * <p>
 * Описание:
 * - Класс Stock хранит цену акции и уведомляет подписчиков об изменении.
 * - Интерфейс StockObserver реализуют классы MobileApp и EmailNotifier для получения уведомлений.
 * - Реализовать подписку и отписку для StockObserver.
 * - Возможность подписки на несколько акций.
 */

@TaskDescription(taskNumber = 11,
        taskDescription = "Реализация системы уведомлений в биржевом приложении",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task11 implements Solution {
    public void execute() {
        Stock station = new Stock();

        MobileApp phone = new MobileApp();
        EmailNotifier email = new EmailNotifier();

        station.addObserver(phone);
        station.addObserver(email);

        station.setPrice("Yandex", 1423.75, 150);
        station.setPrice("Tinkoff", 88.4, 1250);

        System.out.println("\nУдаление одного подписчика (PhoneDisplay) и обновление цен:");
        station.removeObserver(phone);
        station.setPrice("Yandex", 1500.0, 120);
        station.setPrice("Tinkoff", 90.2, 1100);
    }
}
