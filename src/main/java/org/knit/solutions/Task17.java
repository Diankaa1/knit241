package org.knit.solutions;


import org.knit.TaskDescription;
import java.util.Random;

/**
 * Задача 17: Симуляция парадокса Монти Холла
 * <p>
 * Игрок выбирает одну из дверей, за одной из которых спрятан приз.
 * Ведущий открывает пустую дверь. Игрок решает остаться или сменить выбор.
 * <p>
 * Цель: оценить шансы победы при разных стратегиях.
 */

@TaskDescription(taskNumber = 17,
        taskDescription = "Реализация и проверка парадокса Монти Холла",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task17 implements Solution {
    private static final int TOTAL_RUNS = 1_000_000;

    @Override
    public void execute() {
        int switchWins = 0;
        int stayWins = 0;
        Random rng = new Random();

        for (int i = 0; i < TOTAL_RUNS; i++) {
            int winningDoor = rng.nextInt(3);
            int selectedDoor = rng.nextInt(3);

            // Ведущий открывает любую неподходящую дверь
            int openDoor;
            do {
                openDoor = rng.nextInt(3);
            } while (openDoor == winningDoor || openDoor == selectedDoor);

            // Игрок решает поменять выбор
            int alternativeDoor = 3 - selectedDoor - openDoor;
            if (alternativeDoor == winningDoor) {
                switchWins++;
            }

            // Игрок оставляет первоначальный выбор
            if (selectedDoor == winningDoor) {
                stayWins++;
            }
        }

        double switchProb = (switchWins * 100.0) / TOTAL_RUNS;
        double stayProb = (stayWins * 100.0) / TOTAL_RUNS;

        System.out.printf("Победа при смене двери: %.2f%%%n", switchProb);
        System.out.printf("Победа без смены двери: %.2f%%%n", stayProb);
    }
}
