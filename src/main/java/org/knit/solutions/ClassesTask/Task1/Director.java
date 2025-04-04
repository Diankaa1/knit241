package org.knit.solutions.ClassesTask.Task1;

public class Director extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 50000; // Директор одобряет до 50,000
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Директор одобрил запрос на " + amount);
    }
}
