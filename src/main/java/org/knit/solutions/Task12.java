package org.knit.solutions;

import org.knit.solutions.Solution;
import org.knit.solutions.ClassesTask.Task12.Caretaker;
import org.knit.solutions.ClassesTask.Task12.Memento;
import org.knit.solutions.ClassesTask.Task12.TextEditor;

import org.knit.TaskDescription;

/**
 * Задача 12: Реализация системы отмены изменений в текстовом редакторе
 * <p>
 * Описание:
 * - Класс TextEditor содержит текущий текст документа.
 * - Класс Memento хранит снимок состояния текста для возможности отката изменений.
 * - Класс Caretaker управляет историей изменений (стек сохранённых состояний).
 * - Методы saveState() и undo() сохраняют и откатывают изменения.
 * - Возможность нескольких уровней отката изменений.
 */

@TaskDescription(taskNumber = 12,
        taskDescription = "Реализация механизма отмены действий в редакторе текста",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task12 implements Solution {
    @Override
    public void execute() {
        Caretaker history = new Caretaker();

        TextEditor draft1 = new TextEditor("Начальный текст");
        history.saveState(draft1);
        history.gatTempText();

        TextEditor draft2 = new TextEditor("Добавлен второй абзац");
        history.saveState(draft2);
        history.gatTempText();

        TextEditor draft3 = new TextEditor("Финальный вариант");
        history.saveState(draft3);
        history.gatTempText();

        System.out.println("\nВозврат к предыдущим версиям:\n");

        history.undo();
        history.gatTempText();

        history.undo();
        history.gatTempText();

        history.undo(); // Возврат к пустому состоянию

        history.undo(); // Попытка отката за пределы истории
        history.gatTempText();
    }
}
