package ru.trandefil.hw4;

import java.util.HashMap;
import java.util.Map;

public class MailServerMock {

    private static Map<String, Message> inputOutputBox = new HashMap<>();

    public static void clear(){
        inputOutputBox.clear();
    }

    public static String showAll() {
        return inputOutputBox.toString();
    }

    public static void sendMessage(Message message) {
        inputOutputBox.put(message.getAuthor(), message);
    }

    public static Message getMessage(String byName) {
        return inputOutputBox.get(byName);
    }
}
