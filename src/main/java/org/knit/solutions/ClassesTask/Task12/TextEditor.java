package org.knit.solutions.ClassesTask.Task12;

public class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void getText(Memento memento) {
        this.text = memento.getText();
        System.out.println("Текст: " + text);
    }
}
