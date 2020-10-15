package ru.trandefil.hw4.decorator;

import java.util.HashMap;
import java.util.Map;

public class MailServerMock {

    private static Map<String, Message> inputOutputBox = new HashMap<>();

//    static {
//        inputOutputBox.put("John", new Message("John","New York","Text"));
//    }

    public static String showAll(){
        return inputOutputBox.toString();
    }

    public static void sendMessage(Message message){
        inputOutputBox.put(message.getAuthor(), message);
    }

    public static Message getMessage(String byName){
        return inputOutputBox.get(byName);
    }
}
