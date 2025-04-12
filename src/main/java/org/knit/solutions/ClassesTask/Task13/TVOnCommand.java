package org.knit.solutions.ClassesTask.Task13;

public class TVOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Телевизор включен!");
    }

    @Override
    public void undo() {
        System.out.println("Телевизор выключен!");
    }
}
