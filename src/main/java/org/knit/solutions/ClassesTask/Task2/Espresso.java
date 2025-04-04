package org.knit.solutions.ClassesTask.Task2;

// Базовые классы кофе
public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public int getCalories() {
        return 5;
    }
}
