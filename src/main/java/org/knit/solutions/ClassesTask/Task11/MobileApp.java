package org.knit.solutions.ClassesTask.Task11;

public class MobileApp implements StockObserver {
    @Override
    public void update(String name, double price, double volume) {
        System.out.println("Phone Display: Акция " + name + " Цена: " + price  + "$; Объём: " + volume);

    }
}