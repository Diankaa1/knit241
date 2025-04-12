package org.knit.solutions.ClassesTask.Task15;

public class ImageProxy implements Image {
    private RealImage realImage;
    private final String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    private void loadImage() {
        System.out.println("Загрузка изображения (прокси) для: " + filename);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        realImage = new RealImage(filename);
    }

    @Override
    public void display() {
        if (realImage == null) {
            loadImage();
        } else {
            System.out.println("Изображение уже загружено: " + filename);
        }
        realImage.display();
    }
}

