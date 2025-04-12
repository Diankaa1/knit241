package org.knit.solutions.ClassesTask.Task13;

// Конкретные команды
public class LightOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Свет выключен!");
    }

    @Override
    public void undo() {
        System.out.println("Свет включен!");
    }
}
