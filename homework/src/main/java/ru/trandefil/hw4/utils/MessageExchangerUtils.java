package ru.trandefil.hw4.utils;

import ru.trandefil.hw4.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MessageExchangerUtils {

    private static Map<String, String> hideNamesStore = new HashMap<>();

    private static final String ENCRYPT_KEY = "<encrypted>";

    private static Random random = new Random();

    public static Message hideAuthorName(Message message) {
        if (!hideNamesStore.containsKey(message.getAuthor())) {
            hideNamesStore.put(message.getAuthor(), String.valueOf(random.nextInt(1000)));
        }
        message.setAuthor(hideNamesStore.get(message.getAuthor()));
        return message;
    }
    public static String hideAuthorName(String authorName) {
        if (!hideNamesStore.containsKey(authorName)) {
            hideNamesStore.put(authorName, String.valueOf(random.nextInt(1000)));
        }
        return hideNamesStore.get(authorName);
    }

    public static Message encryptMessageText(Message message) {
        message.setText(new StringBuilder(ENCRYPT_KEY).append(message.getText()).append(ENCRYPT_KEY).toString());
        return message;
    }

    public static Message decryptMessageText(Message message) {
        message.setText(message.getText().replace(ENCRYPT_KEY, ""));
        return message;
    }

}
