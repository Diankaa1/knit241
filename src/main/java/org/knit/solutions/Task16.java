package org.knit.solutions;


import org.knit.TaskDescription;

import org.knit.solutions.ClassesTask.Task16.*;

/**
 * Задача 16: Применение паттерна Flyweight для экономии памяти при отображении текста
 * <p>
 * Суть:
 * - Используем повторно уже созданные объекты символов.
 * - Внутренние данные (например, сам символ) кэшируются.
 * - Внешние данные (позиция и стиль) передаются при отрисовке.
 */

@TaskDescription(taskNumber = 16,
        taskDescription = "Паттерн Приспособленец (Flyweight)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task16 implements Solution {

    @Override
    public void execute() {
        String phrase = "Hello, World!";
        int posX = 0;
        int posY = 10;
        String fontStyle = "Calibri 12pt";

        for (char ch : phrase.toCharArray()) {
            TextCharacter glyph = CharacterFactory.getCharacter(ch);
            glyph.render(posX, posY, fontStyle);
            posX += 1; // Сдвигаем по оси X для следующего символа
        }
    }
}
