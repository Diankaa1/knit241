package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task15.*;

/**
 * Задача 15: Применение паттерна Proxy для работы с изображениями
 * <p>
 * Суть:
 * - Загружаем изображения только при первом обращении.
 * - Используем кэширование для последующих вызовов.
 */

@TaskDescription(taskNumber = 15,
        taskDescription = "Паттерн Прокси (Proxy)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task15 implements Solution {

    @Override
    public void execute() {
        Image previewA = new ImageProxy("preview_a.png");
        Image previewB = new ImageProxy("preview_b.jpg");

        System.out.println("Загрузка preview_a (первая попытка):");
        previewA.display(); // Загрузка с задержкой

        System.out.println("\nПовторный показ preview_a (из кеша):");
        previewA.display(); // Без задержки

        System.out.println("\nОбращение к preview_b:");
        previewB.display(); // Загрузка с задержкой

        System.out.println("\nПовторный вызов preview_b:");
        previewB.display(); // Без задержки
    }
}
