package org.knit.solutions.ClassesTask.Task13;

public class TVOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Телевизор выключен!");
    }

    @Override
    public void undo() {
        System.out.println("Телевизор включен!");
    }
}
