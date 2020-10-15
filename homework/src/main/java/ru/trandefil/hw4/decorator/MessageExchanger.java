package ru.trandefil.hw4.decorator;

public interface MessageExchanger {

    void sendMessage(Message message);

    Message getMessage(String byName);
}
