package org.knit.solutions.ClassesTask.Task2;

class Americano implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Американо";
    }

    @Override
    public int getCalories() {
        return 5;
    }
}
