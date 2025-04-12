package org.knit.solutions;


import org.knit.solutions.ClassesTask.Task13.*;

import org.knit.TaskDescription;

/**
 * Задача 13: Командный паттерн для управления устройствами в умном доме
 * <p>
 * Описание:
 * - Интерфейс Command описывает метод execute().
 * - Классы LightOnCommand, LightOffCommand, TVOnCommand, TVOffCommand реализуют действия.
 * - Класс RemoteControl выполняет и откатывает команды.
 */

@TaskDescription(taskNumber = 13,
        taskDescription = "Командный паттерн для управления устройствами в умном доме",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task13 implements Solution {
    @Override
    public void execute() {
        RemoteControl smartRemote = new RemoteControl();

        Command switchLightOn = new LightOnCommand();
        Command switchLightOff = new LightOffCommand();

        Command activateTV = new TVOnCommand();
        Command deactivateTV = new TVOffCommand();

        System.out.println("Запуск сценария управления домом:");

        smartRemote.executeCommand(switchLightOn);
        smartRemote.executeCommand(switchLightOff);
        smartRemote.executeCommand(activateTV);
        smartRemote.executeCommand(deactivateTV);

        System.out.println("\nОткат выполненных действий:");
        smartRemote.undoLastCommand();
        smartRemote.undoLastCommand();
        smartRemote.undoLastCommand();
        smartRemote.undoLastCommand();
        smartRemote.undoLastCommand(); // Попытка отмены при пустом стеке
    }
}
