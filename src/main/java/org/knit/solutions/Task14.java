package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesTask.Task14.*;

/**
 * Задача 14: Паттерн Visitor — анализ структуры файловой системы
 * <p>
 * - Обход дерева объектов с использованием паттерна "Визитер".
 * - Сканирование на вирусы и подсчёт общего размера файлов.
 */

@TaskDescription(taskNumber = 14,
        taskDescription = "Паттерн Визитер (Visitor)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task14 implements Solution {

    @Override
    public void execute() {
        File doc = new File("doc.txt", 400, false);
        File exe = new File("setup.exe", 1500, true);
        File img = new File("photo.png", 800, false);

        Folder userFolder = new Folder("UserFiles");
        userFolder.addElement(doc);
        userFolder.addElement(exe);
        userFolder.addElement(img);

        Shortcut docShortcut = new Shortcut(doc);

        Folder system = new Folder("SystemRoot");
        system.addElement(userFolder);
        system.addElement(docShortcut);

        System.out.println("Запуск антивирусной проверки:");
        VirusScanner scanner = new VirusScanner();
        system.accept(scanner);

        System.out.println("\nАнализ размеров файлов:");
        SizeAnalyzer analyzer = new SizeAnalyzer();
        system.accept(analyzer);
        System.out.println("Суммарный объём данных: " + analyzer.getTotalSize() + " байт");
    }
}
