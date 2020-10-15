package ru.trandefil.hw4.decorator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IncognitoMessageExchanger implements MessageExchanger {

    private MessageExchanger messageExchanger;

    private Map<String, String> hideNamesStore = new HashMap<>();

    private Random random = new Random();

    public IncognitoMessageExchanger(MessageExchanger messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    @Override
    public void sendMessage(Message message) {
        message.setAuthor(hideName(message.getAuthor()));
        messageExchanger.sendMessage(message);
    }

    @Override
    public Message getMessage(String authorName) {
        Message message = messageExchanger.getMessage(hideName(authorName));
        message.setAuthor(authorName);
        return message;
    }

    private String hideName(String name) {
        if (!hideNamesStore.containsKey(name)) {
            hideNamesStore.put(name, String.valueOf(random.nextInt(1000)));
        }
        return hideNamesStore.get(name);
    }
}
