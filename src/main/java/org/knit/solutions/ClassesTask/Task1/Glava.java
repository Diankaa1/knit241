package org.knit.solutions.ClassesTask.Task1;

public class Glava extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 1000000;
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Диана одобрила запрос на " + amount);
    }
}
