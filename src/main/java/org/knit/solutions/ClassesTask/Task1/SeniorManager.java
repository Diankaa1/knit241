package org.knit.solutions.ClassesTask.Task1;

public class SeniorManager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 10000;
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Старший менеджер одобрил запрос на " + amount);
    }
}
