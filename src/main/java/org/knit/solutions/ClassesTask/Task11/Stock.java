package org.knit.solutions.ClassesTask.Task11;

import java.util.ArrayList;
import java.util.List;

// Поставщик данных о торгах
public class Stock {
    private final List<StockObserver> subscribers = new ArrayList<>();
    private String ticker;
    private double currentPrice;
    private double tradeVolume;

    public void addObserver(StockObserver subscriber) {
        subscribers.add(subscriber);
    }

    public void removeObserver(StockObserver subscriber) {
        subscribers.remove(subscriber);
    }

    public void setPrice(String ticker, double price, double volume) {
        this.ticker = ticker;
        this.currentPrice = price;
        this.tradeVolume = volume;
        informSubscribers();
    }

    private void informSubscribers() {
        for (StockObserver sub : subscribers) {
            sub.update(ticker, currentPrice, tradeVolume);
        }
    }
}
