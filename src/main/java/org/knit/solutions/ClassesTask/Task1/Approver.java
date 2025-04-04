package org.knit.solutions.ClassesTask.Task1;

// Абстрактный класс обработчика
public abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Trubble trubble) {
        if (canApprove(trubble.sum)) {
            approve(trubble.sum);
        } else if (nextApprover != null) {
            nextApprover.processRequest(trubble); // Передача запроса дальше
        } else {
            System.out.println("Запрос " + trubble.name + " отклонен: превышает лимит.");
        }
    }

    protected abstract boolean canApprove(int amount); // Проверка лимита

    protected abstract void approve(int amount); // Логика одобрения
}
