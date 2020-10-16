package ru.trandefil.hw4;

public class Message {
    private String author;
    private String address;
    private String text;

    public Message(String author, String address, String text) {
        this.author = author;
        this.address = address;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", address='" + address + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
