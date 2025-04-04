package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task5.Restaurant;

/**
 * Описание:
 * В ресторане работает один повар и один официант.
 *
 * Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
 * Официант берет готовые блюда и подает их клиентам.
 * Что нужно реализовать?
 * Повар не может готовить больше 3 блюд (ждет wait()).
 * Официант ждет, если поднос пуст (wait()).
 * При каждой передаче блюда используется notify().
 */
@TaskDescription(taskNumber = 5, taskDescription = "Задача «Ресторан: Повар и Официант»", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task5 implements Solution {
    @Override
    public void execute() {
        Restaurant restaurant = new Restaurant();

        Thread chef = new Thread(() -> {
            String[] meals = {"Суп", "Стейк", "Салат", "Пицца", "Рыба", "Курица", "Рагу", "Торт", "Рис", "Лапша"};
            for (int i = 0; i < meals.length; i++) {
                System.out.printf("Повар начинает готовить %s [%d/%d]. На подносе сейчас: %d\n",
                        meals[i], i + 1, meals.length, restaurant.getQueueSize());
                restaurant.cook(meals[i]);
                try {
                    Thread.sleep(500); // Имитация времени на приготовление блюда
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread waiter = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("Официант проверяет поднос. Блюд сейчас: %d\n", restaurant.getQueueSize());
                restaurant.serve();
                try {
                    Thread.sleep(800); // Имитация времени на подачу блюда
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        chef.start();
        waiter.start();
    }
}
