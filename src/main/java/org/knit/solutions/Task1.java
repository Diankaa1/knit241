package org.knit.solutions;

import org.knit.solutions.ClassesTask.Task1.*;

// Демонстрация работы цепочки
import org.knit.TaskDescription;

/**
 * Описание:
 * Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его. Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.
 *
 * Пример из жизни:
 * Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает к оператору первого уровня (обычный оператор), затем, если он не может решить проблему, передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.
 *
 * Задача:
 * Реализуйте систему обработки жалоб клиентов в банке.
 *
 * Жалоба сначала поступает в колл-центр.
 * Если проблема сложная, запрос передается менеджеру.
 * Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
 * Каждый уровень обработки либо решает проблему, либо передает ее дальше. (не менее 4х уровней поддержки)
 * Представить проблему в виде объекта, с описанием, уровнем сложности.
 */
@TaskDescription(taskNumber = 1, taskDescription = "Цепочка обязанностей", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task1 implements Solution {
    @Override
    public void execute() {
        // Создаем обработчиков
        Approver junior = new JuniorManager();
        Approver senior = new SeniorManager();
        Approver director = new Director();
        Approver glava = new Glava();

        // Устанавливаем цепочку: junior -> senior -> director
        junior.setNextApprover(senior);
        senior.setNextApprover(director);
        director.setNextApprover(glava);

        Trubble trubble1 = new Trubble("Первая проблема", 100);
        Trubble trubble2 = new Trubble("Вторая проблема", 10000);
        Trubble trubble3 = new Trubble("Третья проблема", 40000);
        Trubble trubble4 = new Trubble("Четвертая проблема", 100000);
        Trubble trubble5 = new Trubble("Пятая проблема", 100000000);

        // Запросы на одобрение разных сумм
        junior.processRequest(trubble1);
        junior.processRequest(trubble2);
        junior.processRequest(trubble3);
        junior.processRequest(trubble4);
        junior.processRequest(trubble5);
    }
}

